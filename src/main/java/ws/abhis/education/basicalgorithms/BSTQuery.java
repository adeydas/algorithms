package ws.abhis.education.basicalgorithms;


import ws.abhis.education.utils.IntegerTreeNode;

/**
 * Using DFS.
 */
public class BSTQuery {
  public boolean query(IntegerTreeNode node, int query) {
    if (node == null) {
      return false;
    }
    if (node.getValue() == query) {
      return true;
    }
    if (node.getLeftChild() != null) {
      return query(node.getLeftChild(), query);
    }
    if (node.getRightChild() != null) {
      return query(node.getRightChild(), query);
    }

    return false;
  }
}
