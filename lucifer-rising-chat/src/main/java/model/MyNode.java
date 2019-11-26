package model;

import java.util.Arrays;
import java.util.Map;

//  TODO add metadata to json - discuss format
public class MyNode {
  private int id;
  private String description;
  private String type;
  private int[] nextNodeIDs;
  //private Map<String, Integer> metaData;

  public MyNode(int id, String description, String type, int[] nextNodeIDs) { //,Map<String, Integer> metaData) {
    this.id = id;
    this.description = description;
    this.type = type;
    this.nextNodeIDs = nextNodeIDs;
    //this.metaData = metaData;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int[] getNextNodeIDs() {
    return nextNodeIDs;
  }

  public void setNextNodeIDs(int[] nextNodeIDs) {
    this.nextNodeIDs = nextNodeIDs;
  }
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    MyNode node = (MyNode) obj;

    return (id == node.id
      && (description.equals(node.description))
      && (type.equals(node.type))
      && (Arrays.equals(nextNodeIDs,node.nextNodeIDs)));
  }
}
