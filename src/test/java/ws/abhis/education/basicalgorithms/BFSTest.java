package ws.abhis.education.basicalgorithms;

import org.junit.Test;
import ws.abhis.education.utils.BinaryTreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BFSTest {
  @Test
  public void bfs() throws Exception {
    BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), new BinaryTreeNode(5, null, null)), new BinaryTreeNode(3, null, new BinaryTreeNode(7, null, null)));
    BFS bfs = new BFS();
    assertTrue(bfs.bfs(node, 3));
    assertFalse(bfs.bfs(node, 6));
  }

}