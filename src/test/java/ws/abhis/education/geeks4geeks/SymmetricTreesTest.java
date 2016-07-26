package ws.abhis.education.geeks4geeks;

import org.junit.Before;
import org.junit.Test;
import ws.abhis.education.utils.BinaryTreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SymmetricTreesTest {

  private BinaryTreeNode goodTree;
  private BinaryTreeNode badTree;

  private SymmetricTrees symmetricTrees;

  @Before
  public void setup() {
    goodTree = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(3, null, null), new BinaryTreeNode(4, null, null)), new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), new BinaryTreeNode(3, null, null)));
    badTree = new BinaryTreeNode(1, new BinaryTreeNode(2, null, new BinaryTreeNode(3, null, null)), new BinaryTreeNode(2, null, new BinaryTreeNode(3, null, null)));

    symmetricTrees = new SymmetricTrees();
  }

  @Test
  public void testWithGoodTree() {
    assertTrue(symmetricTrees.isMirror(goodTree));
  }

  @Test
  public void testWithBadTree() {
    assertFalse(symmetricTrees.isMirror(badTree));
  }
}