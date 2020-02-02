package de.softwartechnik.lucifer.tree;

import de.softwartechnik.lucifer.tree.QuestionNode.Choice;
import de.softwartechnik.lucifer.tree.io.ChoiceModel;
import de.softwartechnik.lucifer.tree.io.DeathNodeModel;
import de.softwartechnik.lucifer.tree.io.EndNodeModel;
import de.softwartechnik.lucifer.tree.io.MessageNodeModel;
import de.softwartechnik.lucifer.tree.io.NodeModel;
import de.softwartechnik.lucifer.tree.io.QuestionNodeModel;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum NodeType {
  DEATH(DeathNode.class, DeathNodeModel.class) {
    @Override
    Node convert(NodeModel nodeModel, Map<String, NodeModel> nodes) {
      return DeathNode.create();
    }
  },
  END(EndNode.class, EndNodeModel.class) {
    @Override
    Node convert(NodeModel nodeModel, Map<String, NodeModel> nodes) {
      return EndNode.create();
    }
  },
  MESSAGE(MessageNode.class, MessageNodeModel.class) {
    @Override
    Node convert(NodeModel nodeModel, Map<String, NodeModel> nodes) {
      MessageNodeModel messageNodeModel = (MessageNodeModel) nodeModel;
      NodeModel nextNodeModel = nodes.get(messageNodeModel.nextNode());
      Node nextNode = Tree.parseTreeNode(nextNodeModel, nodes);
      return MessageNode.of(messageNodeModel.message(), nextNode);
    }
  },
  QUESTION(QuestionNode.class, QuestionNodeModel.class) {
    @Override
    Node convert(NodeModel nodeModel, Map<String, NodeModel> nodes) {
      QuestionNodeModel questionNodeModel = (QuestionNodeModel) nodeModel;
      ChoiceModel[] choiceModels = questionNodeModel.choices();
      List<Choice> choices = Arrays.stream(choiceModels).map(choiceModel -> {
        NodeModel nextNodeModel = nodes.get(choiceModel.nextNode());
        Node nextNode = Tree.parseTreeNode(nextNodeModel, nodes);
        return Choice.of(Pattern.compile(choiceModel.pattern()).asMatchPredicate(), nextNode);
      }).collect(Collectors.toList());
      return QuestionNode.newBuilder()
        .withQuestion(questionNodeModel.question())
        .withChoices(choices)
        .create();
    }
  };

  private final Class<? extends Node> nodeType;
  private final Class<? extends NodeModel> nodeModelType;

  NodeType(
    Class<? extends Node> nodeType,
    Class<? extends NodeModel> nodeModelType
  ) {
    this.nodeType = nodeType;
    this.nodeModelType = nodeModelType;
  }

  public static Optional<NodeType> findByModelType(Class<? extends NodeModel> nodeModelType) {
    return Arrays.stream(values())
      .filter(nodeType -> nodeModelType.equals(nodeType.nodeModelType))
      .findFirst();
  }

  public Class<? extends Node> nodeType() {
    return nodeType;
  }

  public Class<? extends NodeModel> nodeModelType() {
    return nodeModelType;
  }

  abstract Node convert(NodeModel nodeModel, Map<String, NodeModel> nodes);
}
