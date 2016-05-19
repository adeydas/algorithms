package ws.abhis.education.basicalgorithms;

import org.junit.Test;
import ws.abhis.education.utils.IntegerTreeNode;

import static org.junit.Assert.assertTrue;


public class BSTQueryTest {
  @Test
  public void query() throws Exception {
    IntegerTreeNode node = new IntegerTreeNode(4, new IntegerTreeNode(3, new IntegerTreeNode(1, null, null), null), new IntegerTreeNode(5, new IntegerTreeNode(6, null, null), new IntegerTreeNode(7, null, null)));
    int query = 3;
    BSTQuery bstQuery = new BSTQuery();
    assertTrue(bstQuery.query(node, query));
  }

}