package ws.abhis.education.leetcode;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * https://wiki.abhis.ws/index.php/Longest_Substring_Without_Repeating_Characters
 */
public class LongestSubstringWoRepeatChars {

    public int lengthOfLongestSubstring(String s) {
        int longestWindowSize = 0;
        Set<Character> slidingWindow = new HashSet<>();

        if (s.length() <= 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int windowStartIndex = 0;
        slidingWindow.add(s.charAt(windowStartIndex));
        int windowTailIndex = 1;

        while (windowTailIndex < s.length()) {
            if (slidingWindow.contains(s.charAt(windowTailIndex))) {
                longestWindowSize = Math.max(longestWindowSize, slidingWindow.size());
                slidingWindow.remove(s.charAt(windowStartIndex));
                windowStartIndex = windowStartIndex + 1;
                windowTailIndex = windowTailIndex + 1;
            } else {
                slidingWindow.add(s.charAt(windowTailIndex));
                windowTailIndex = windowTailIndex + 1;
            }
        }

        return longestWindowSize;
    }
}
