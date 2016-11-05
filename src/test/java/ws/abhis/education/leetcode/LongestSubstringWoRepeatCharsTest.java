package ws.abhis.education.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhishek on 11/5/16.
 */
public class LongestSubstringWoRepeatCharsTest {


    @Test
    public void lengthOfLongestSubstring1() throws Exception {
        LongestSubstringWoRepeatChars longestSubstringWoRepeatChars = new LongestSubstringWoRepeatChars();
        int length = longestSubstringWoRepeatChars.lengthOfLongestSubstring("pwwkew");

        assertEquals(length, 3);
    }

    @Test
    public void lengthOfLongestSubstring2() throws Exception {
        LongestSubstringWoRepeatChars longestSubstringWoRepeatChars = new LongestSubstringWoRepeatChars();
        int length = longestSubstringWoRepeatChars.lengthOfLongestSubstring("abcabcbb");

        assertEquals(length, 3);
    }

    @Test
    public void lengthOfLongestSubstring3() throws Exception {
        LongestSubstringWoRepeatChars longestSubstringWoRepeatChars = new LongestSubstringWoRepeatChars();
        int length = longestSubstringWoRepeatChars.lengthOfLongestSubstring("bbbbb");

        assertEquals(length, 1);
    }

}