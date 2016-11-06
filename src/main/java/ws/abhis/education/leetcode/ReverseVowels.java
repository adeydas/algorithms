package ws.abhis.education.leetcode;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/91
 */
public class ReverseVowels {

    private static List<Character> vowels = new ArrayList<>();

    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public String reverseVowels(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }

        char[] result = reverseVowels(s.toCharArray());
        return new String(result);
    }

    private char[] reverseVowels (char[] s) {
        int startPointer = 0;
        int endPointer = s.length-1;

        while (startPointer < endPointer && startPointer <= s.length - 1 && endPointer >= 0) {
            while (!vowels.contains(s[startPointer])) {
                startPointer = startPointer + 1;
            }
            while (!vowels.contains(s[endPointer])) {
                endPointer = endPointer - 1;
            }
            char temp = s[startPointer];
            s[startPointer] = s[endPointer];
            s[endPointer] = temp;
            startPointer = startPointer + 1;
            endPointer = endPointer - 1;
        }

        return s;
    }
}
