package ws.abhis.education.old.geeks4geeks;

import junit.framework.TestCase;

/**
 * Given an unsorted array, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74.

 Expected Time Complexity: O(n) [Only one traversal of array is allowed]
 */
public class LargestPairSum extends TestCase {
    public int findLargestSumPair(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            int t = nums[i];

            if (t >= first) {
                int temp = first;
                first = t;
                second = temp;
            }
            if (second == Integer.MIN_VALUE && t != first)
                second = t;

        }
        return first + second;
    }

    public void testOne() {
        int[] nums = new int[] {12, 34, 10, 6, 40};
        assertTrue(findLargestSumPair(nums) == 74);
    }
    public void testTwo() {
        int[] nums = new int[] {10,2};
        assertTrue(findLargestSumPair(nums) == 12);
    }
    public void testThree() {
        int[] nums = new int[] {10,10,2};
        assertTrue(findLargestSumPair(nums) == 20);
    }
    public void testFour() {
        int[] nums = new int[] {2,10};
        assertTrue(findLargestSumPair(nums) == 12);
    }
    public void testFive() {
        int[] nums = new int[] {2};
        assertTrue(findLargestSumPair(nums) == 2);
    }
}
