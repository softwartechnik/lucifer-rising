package gson;

import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
  private final Class<?> baseType;
  private final String typeFieldName;
  private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap<String, Class<?>>();
  private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap<Class<?>, String>();

  private RuntimeTypeAdapterFactory(Class<?> baseType, String typeFieldName) {
    if (typeFieldName == null || baseType == null) {
      throw new NullPointerException();
    }
    this.baseType = baseType;
    this.typeFieldName = typeFieldName;
  }

  public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType, String typeFieldName) {
    return new RuntimeTypeAdapterFactory<T>(baseType, typeFieldName);
  }

  public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType) {
    return new RuntimeTypeAdapterFactory<T>(baseType, "type");
  }

  public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> type, String label) {
    if (type == null || label == null) {
      throw new NullPointerException();
    }
    if (subtypeToLabel.containsKey(type) || labelToSubtype.containsKey(label)) {
      throw new IllegalArgumentException("types and labels must be unique");
    }
    labelToSubtype.put(label, type);
    subtypeToLabel.put(type, label);
    return this;
  }

  public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> type) {
    return registerSubtype(type, type.getSimpleName());
  }

  public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
    if (type.getRawType() != baseType) {
      return null;
    }

    final Map<String, TypeAdapter<?>> labelToDelegate
      = new LinkedHashMap<String, TypeAdapter<?>>();
    final Map<Class<?>, TypeAdapter<?>> subtypeToDelegate
      = new LinkedHashMap<Class<?>, TypeAdapter<?>>();
    for (Map.Entry<String, Class<?>> entry : labelToSubtype.entrySet()) {
      TypeAdapter<?> delegate = gson.getDelegateAdapter(this, TypeToken.get(entry.getValue()));
      labelToDelegate.put(entry.getKey(), delegate);
      subtypeToDelegate.put(entry.getValue(), delegate);
    }

    return new TypeAdapter<R>() {
      @Override public R read(JsonReader in) throws IOException {
        JsonElement jsonElement = Streams.parse(in);
        JsonElement labelJsonElement = jsonElement.getAsJsonObject().remove(typeFieldName);
        if (labelJsonElement == null) {
          throw new JsonParseException("cannot deserialize " + baseType
            + " because it does not define a field named " + typeFieldName);
        }
        String label = labelJsonElement.getAsString();
        @SuppressWarnings("unchecked") // registration requires that subtype extends T
          TypeAdapter<R> delegate = (TypeAdapter<R>) labelToDelegate.get(label);
        if (delegate == null) {
          throw new JsonParseException("cannot deserialize " + baseType + " subtype named "
            + label + "; did you forget to register a subtype?");
        }
        return delegate.fromJsonTree(jsonElement);
      }

      @Override public void write(JsonWriter out, R value) throws IOException {
        Class<?> srcType = value.getClass();
        String label = subtypeToLabel.get(srcType);
        @SuppressWarnings("unchecked") // registration requires that subtype extends T
          TypeAdapter<R> delegate = (TypeAdapter<R>) subtypeToDelegate.get(srcType);
        if (delegate == null) {
          throw new JsonParseException("cannot serialize " + srcType.getName()
            + "; did you forget to register a subtype?");
        }
        JsonObject jsonObject = delegate.toJsonTree(value).getAsJsonObject();
        if (jsonObject.has(typeFieldName)) {
          throw new JsonParseException("cannot serialize " + srcType.getName()
            + " because it already defines a field named " + typeFieldName);
        }
        JsonObject clone = new JsonObject();
        clone.add(typeFieldName, new JsonPrimitive(label));
        for (Map.Entry<String, JsonElement> e : jsonObject.entrySet()) {
          clone.add(e.getKey(), e.getValue());
        }
        Streams.write(clone, out);
      }
    }.nullSafe();
  }
}