package ws.abhis.education.basicalgorithms;


import ws.abhis.education.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  public boolean bfs(BinaryTreeNode node, int searchVal) {
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      BinaryTreeNode n = queue.remove();
      int v = (Integer) n.getValue();
      if (v == searchVal) {
        return true;
      }
      if (n.getLeftChild() != null) {
        queue.add(n.getLeftChild());
      }
      if (n.getRightChild() != null) {
        queue.add(n.getRightChild());
      }
    }
    return false;
  }
}
