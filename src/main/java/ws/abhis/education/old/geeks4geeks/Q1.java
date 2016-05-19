package ws.abhis.education.old.geeks4geeks;

import ws.abhis.education.utils.SingleLinkedListNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms/tree/1-check-if-a-singly-linked-list-of-strings-forms-a-palindrome
 **/

public class Q1 {

  /**
   * Convert a linkedlist into String.
   * @param root
   * @return
   */
  private static String linkedListToString(SingleLinkedListNode root) {
    StringBuilder builder = new StringBuilder();
    while (root != null) {
      String val = (String)root.getValue();
      builder.append(val);
      root = root.getNextNode();
    }
    return builder.toString();
  }

  /**
   * Check if a String is palindrome.
   * @param s
   * @return
   */
  private static boolean isPalindrone(String s) {
    int size = s.length()-1;
    int i = 0, j = size;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++; j--;
    }
    return true;
  }

  /**
   * a -> bc -> d -> dcb -> a -> NULL
   * @return
   */
  private static SingleLinkedListNode prepareTrueList() {
    return new SingleLinkedListNode("a", new SingleLinkedListNode("bc", new SingleLinkedListNode("d",
      new SingleLinkedListNode("dcb", new SingleLinkedListNode("a", null)))));
  }

  /**
   * a -> bc -> d -> ba -> NULL
   * @return
   */
  private static SingleLinkedListNode prepareFalseList() {
    return new SingleLinkedListNode("a", new SingleLinkedListNode("bc", new SingleLinkedListNode("d",
      new SingleLinkedListNode("ba", null))));
  }

  public static void main(String... args) {
    assertTrue(isPalindrone(linkedListToString(prepareTrueList())));
    assertFalse(isPalindrone(linkedListToString(prepareFalseList())));
  }
}
