package de.softwartechnik.lucifer.tree;

import de.softwartechnik.lucifer.tree.io.NodeModel;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Tree {
  private final String name;
  private final Node rootNode;

  public Tree(String name, Node rootNode) {
    this.name = name;
    this.rootNode = rootNode;
  }

  public String name() {
    return name;
  }

  static Tree of(String name, Collection<NodeModel> nodeModels) {
    Objects.requireNonNull(name);
    Objects.requireNonNull(nodeModels);
    Map<String, NodeModel> nodes = nodeModels.stream()
      .collect(Collectors.toMap(NodeModel::id, model -> model));
    Node rootNode = parseTree(nodes);
    return new Tree(name, rootNode);
  }

  private static final String INITIAL_NODE_ID = "0";

  private static Node parseTree(Map<String, NodeModel> nodes) {
    NodeModel initialNodeModel = nodes.get(INITIAL_NODE_ID);
    return parseTreeNode(initialNodeModel, nodes);
  }

  static Node parseTreeNode(NodeModel nodeModel, Map<String, NodeModel> nodes) {
    NodeType nodeType = NodeType.findByModelType(nodeModel.getClass()).orElseThrow();
    return nodeType.convert(nodeModel, nodes);
  }
}
