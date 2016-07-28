package ws.abhis.education.programminginterviewsexposed;

import ws.abhis.education.utils.BinaryTreeNode;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/58
 */
public class HeightOfBT {

  private int calculateHeight(BinaryTreeNode node) {
    int leftTreeHeight = 0;
    int rightTreeHeight = 0;

    if (null != node.getLeftChild()) {
      leftTreeHeight += calculateHeight(node.getLeftChild()) + 1;
    }

    if (null != node.getRightChild()) {
      rightTreeHeight += calculateHeight(node.getRightChild()) + 1;
    }

    return leftTreeHeight >= rightTreeHeight ? leftTreeHeight : rightTreeHeight;
  }

  public int getHeightOfBinaryTree(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    } else {
      // +1 because we need to consider the root.
      return calculateHeight(root) + 1;
    }
  }
}
