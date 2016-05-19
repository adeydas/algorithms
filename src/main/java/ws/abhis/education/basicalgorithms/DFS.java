package ws.abhis.education.basicalgorithms;


import ws.abhis.education.utils.BinaryTreeNode;

public class DFS {
  public  void dfs(BinaryTreeNode node) {
    System.out.println("Found element " + node.getValue());
    if (node.getLeftChild() != null) {
      dfs(node.getLeftChild());
    }
    if (node.getRightChild() != null) {
      dfs(node.getRightChild());
    }
  }
}
