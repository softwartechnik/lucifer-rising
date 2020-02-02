package de.softwartechnik.lucifer.tree;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public final class QuestionNode implements Node {
  private final String question;
  private final AtomicReference<Status> status;
  private final Set<Choice> choices;

  private QuestionNode(
    String question,
    Status status,
    Set<Choice> choices
  ) {
    this.question = question;
    this.status = new AtomicReference<>(status);
    this.choices = choices;
  }

  @Override
  public void accept(MessageContext messageContext) {
    if (status.get() == Status.QUESTION) {
      sendQuestion(messageContext);
    } else if (status.get() == Status.ANSWER) {
      evaluateAnswer(messageContext);
    }
  }

  private void evaluateAnswer(MessageContext messageContext) {
    var message = messageContext.message();
    findChoice(message).ifPresentOrElse(
      choice -> followChoice(choice, messageContext),
      () -> askQuestionAfterInvalidChoice(messageContext)
    );
  }

  private void askQuestionAfterInvalidChoice(MessageContext messageContext) {
    messageContext.respond("Das verstehe ich nicht!");
    messageContext.respond(question);
  }

  private Optional<Choice> findChoice(String message) {
    return choices.stream()
      .filter(choice -> choice.test(message))
      .findFirst();
  }

  private void followChoice(Choice choice, MessageContext messageContext) {
    var nextNode = choice.nextNode;
    messageContext.resume(nextNode);
  }

  private void sendQuestion(MessageContext messageContext) {
    messageContext.respond(question);
    status.compareAndSet(Status.QUESTION, Status.ANSWER);
  }

  private enum Status {
    QUESTION,
    ANSWER;
  }

  public static Builder newBuilder() {
    return new Builder(new HashSet<>());
  }

  public static final class Builder {
    private String question;
    private Collection<Choice> choices;

    private Builder(Collection<Choice> choices) {
      this.choices = choices;
    }

    public Builder withQuestion(String question) {
      Objects.requireNonNull(question);
      this.question = question;
      return this;
    }

    public Builder addChoice(Choice choice) {
      Objects.requireNonNull(choice);
      choices.add(choice);
      return this;
    }

    public Builder withChoices(Collection<Choice> choices) {
      Objects.requireNonNull(choices);
      choices.forEach(this::addChoice);
      return this;
    }

    public QuestionNode create() {
      Objects.requireNonNull(question);
      Objects.requireNonNull(choices);
      return new QuestionNode(
        question,
        Status.QUESTION,
        Set.copyOf(choices)
      );
    }
  }

  public static final class Choice implements Predicate<String> {
    private final Predicate<String> matcher;
    private final Node nextNode;

    public Choice(Predicate<String> matcher, Node nextNode) {
      this.matcher = matcher;
      this.nextNode = nextNode;
    }

    public static Choice of(Predicate<String> matcher, Node nextNode) {
      Objects.requireNonNull(matcher);
      Objects.requireNonNull(nextNode);
      return new Choice(matcher, nextNode);
    }

    @Override
    public boolean test(String message) {
      return matcher.test(message);
    }
  }
}
