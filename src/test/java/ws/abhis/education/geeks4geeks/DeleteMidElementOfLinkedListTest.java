package ws.abhis.education.geeks4geeks;

import org.junit.Before;
import org.junit.Test;
import ws.abhis.education.utils.SingleLinkedListNode;


public class DeleteMidElementOfLinkedListTest {

  private SingleLinkedListNode evenNodes;
  private SingleLinkedListNode oddNodes;

  private DeleteMidElementOfLinkedList deleteMidElementOfLinkedList;

  @Before
  public void setup() {
    evenNodes = new SingleLinkedListNode(1, new SingleLinkedListNode(2, new SingleLinkedListNode(3, new SingleLinkedListNode(4, null))));
    oddNodes = new SingleLinkedListNode(1, new SingleLinkedListNode(2, new SingleLinkedListNode(3, null)));

    deleteMidElementOfLinkedList = new DeleteMidElementOfLinkedList();
  }

  @Test
  public void testWithEventNodes() {
    deleteMidElementOfLinkedList.removeMidElement(evenNodes);
    while (null != evenNodes) {
      System.out.println(evenNodes.getValue());
      evenNodes = evenNodes.getNextNode();
    }
  }

  @Test
  public void testWithOddNodes() {
    deleteMidElementOfLinkedList.removeMidElement(oddNodes);
    while (null != oddNodes) {
      System.out.println(oddNodes.getValue());
      oddNodes = oddNodes.getNextNode();
    }
  }
}