package ws.abhis.education.old;

import junit.framework.TestCase;

/**
 * DT2
 */
public class DT2 extends TestCase {
    public boolean isPalindrome(String inputString) {
        inputString = inputString.toLowerCase(); //since its case insensitive
        //An empty string is a palindrome
        if (inputString == null || inputString.length() == 0)
            return true;

        int low = 0;
        int high = inputString.length()-1;

        while (low < high)  {
            if (inputString.charAt(low) < 'a' || inputString.charAt(high) > 'z') {
                low = low + 1;
                continue;
            }
            if (inputString.charAt(high) < 'a' || inputString.charAt(high) > 'z') {
                high = high - 1;
                continue;
            }
            if (inputString.charAt(low) != inputString.charAt(high))
                return false;
            low = low + 1;
            high = high - 1;
        }

        return true;
    }

    public void testOne() {
        assertTrue(isPalindrome(""));
    }
    public void testTwo() {
        assertTrue(isPalindrome("a") && isPalindrome("A"));
    }
    public void testThree() {
        assertTrue(isPalindrome("pop"));
    }
    public void testFour() {
        assertTrue(isPalindrome("Ah, Satan sees Natasha"));
    }
    public void testFive() {
        assertTrue(!isPalindrome("nop   gop lop...."));
    }
    public void testSix() {
        assertTrue(isPalindrome(" "));
    }
    public void testSeven() {
        assertTrue(isPalindrome("....pop!"));
    }
}
