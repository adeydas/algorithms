package ws.abhis.education.old.gayle;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q6 {

  // O(n2)
  private static boolean bruteForce(String s) {
    for (int i=0; i<s.length(); i++) {
      char singleChar = s.charAt(i);
      for (int k=0; k<s.length(); k++) {
        if (i!=k) {
          if (singleChar == s.charAt(k)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  // O(n)
  private static boolean bitManipulation(String s) {
    int c = 0;
    for (int i=0; i<s.length(); i++) {
      int v = s.charAt(i) - 'a';
      if ((c & (1 << v)) > 0) {
        return false;
      }
      c |= (1 << v);
    }
    return true;
  }

  // O(nlgn)
  private static boolean sortMethod(String s) {
    char[] ar = s.toCharArray();
    Arrays.sort(ar);
    String sorted = String.valueOf(ar);

    for (int i=0, j=1; j<sorted.length(); i++, j++) {
      if (s.charAt(i) == s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String... args) {
    assertTrue(bruteForce("abcd"));
    assertFalse(bruteForce("aabc"));

    assertTrue(bitManipulation("abcd"));
    assertFalse(bitManipulation("aabc"));

    assertTrue(sortMethod("abcd"));
    assertFalse(sortMethod("aabc"));
  }
}
