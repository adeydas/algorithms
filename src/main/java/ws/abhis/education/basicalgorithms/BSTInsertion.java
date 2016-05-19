package ws.abhis.education.basicalgorithms;


import ws.abhis.education.utils.IntegerTreeNode;

public class BSTInsertion {
  public IntegerTreeNode createTree(IntegerTreeNode currentNode, IntegerTreeNode nodeToInsert) {
    // If there is no tree, the nodeToInsert forms the tree
    if (currentNode == null) {
      return nodeToInsert;
    } else if (nodeToInsert.getValue() < currentNode.getValue()) {
      currentNode.setLeftChild(createTree(currentNode.getLeftChild(), nodeToInsert));
    } else if (nodeToInsert.getValue() > currentNode.getValue()) {
      currentNode.setRightChild(createTree(currentNode.getRightChild(), nodeToInsert));
    }
    return currentNode;
  }
}
