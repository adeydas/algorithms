package ws.abhis.education.geeks4geeks;


import ws.abhis.education.utils.BinaryTreeNode;

public class SymmetricTrees {

  private boolean isMirror(BinaryTreeNode node1, BinaryTreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }

    if (null != node1 && null != node2 && node1.getValue() == node2.getValue()) {
      return isMirror(node1.getLeftChild(), node2.getRightChild());
    }

    return false;
  }

  public boolean isMirror(BinaryTreeNode root) {
    return isMirror(root, root);
  }
}
