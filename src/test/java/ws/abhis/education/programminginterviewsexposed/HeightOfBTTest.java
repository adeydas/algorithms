package ws.abhis.education.programminginterviewsexposed;

import org.junit.Before;
import org.junit.Test;
import ws.abhis.education.utils.BinaryTreeNode;

import static org.junit.Assert.assertEquals;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/58
 */
public class HeightOfBTTest {

  private HeightOfBT heightOfBT;
  private BinaryTreeNode root;

  @Before
  public void setup() {
    root = new BinaryTreeNode(1, new BinaryTreeNode(2, null, null), new BinaryTreeNode(3, new BinaryTreeNode(4, null, null), null));
    heightOfBT = new HeightOfBT();
  }

  @Test
  public void testWithOurTree() {
    assertEquals(heightOfBT.getHeightOfBinaryTree(root), 3);
  }
}