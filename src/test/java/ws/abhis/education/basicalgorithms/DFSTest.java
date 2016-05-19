package ws.abhis.education.basicalgorithms;

import org.junit.Test;
import ws.abhis.education.utils.BinaryTreeNode;

public class DFSTest {
  @Test
  public void dfs() throws Exception {
    BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), new BinaryTreeNode(5, null, null)), new BinaryTreeNode(3, null, new BinaryTreeNode(7, null, null)));
    DFS dfs = new DFS();
    dfs.dfs(node);
  }

}