package ws.abhis.education.old.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> allTriplets = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++) {

            if (i>0 && nums[i]==nums[i-1]) continue;

            int l = i+1;
            int r = nums.length-1;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ArrayList t = new ArrayList();
                    t.add(nums[i]); t.add(nums[l]); t.add(nums[r]);
                    allTriplets.add(t);
                    do { l++; } while (l<r && nums[l] == nums[l-1]);
                    do { r--; } while (l<r && nums[r] == nums[r+1]);
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return allTriplets;
    }

    public static void main(String... args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[] {-2,0,1,1,2};
        List<List<Integer>> r = new ArrayList<>();
        r = threeSum.threeSum(nums);

        for (List<Integer> l : r) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
