package ws.abhis.education.basicalgorithms;

import org.junit.Test;
import ws.abhis.education.utils.IntegerTreeNode;


public class BSTInsertionTest {
  @Test
  public void createTree() throws Exception {
    IntegerTreeNode node = null;
    IntegerTreeNode nodeToInsert = new IntegerTreeNode(4, null, null);
    BSTInsertion bstInsertion = new BSTInsertion();
    bstInsertion.createTree(node, nodeToInsert);
  }

}