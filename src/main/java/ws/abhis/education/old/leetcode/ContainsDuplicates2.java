package ws.abhis.education.old.leetcode;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicates2 extends TestCase {

    /**
     * Check if exists in map and find the difference between indexes, if <= k return true
     * else replace with new index
     *
     * if not in map, populate in map.
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>(); //map of number, index

        for (int i=0; i<nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                int index = mp.get(nums[i]);
                if (Math.abs(index - i) <= k)
                    return true;
            }
            mp.put(nums[i], i);
        }
        return false;
    }

    public void testOne() {
        int[] nums = new int[] {1,0,1,1};
        assertTrue(containsNearbyDuplicate(nums, 1));
    }
}
