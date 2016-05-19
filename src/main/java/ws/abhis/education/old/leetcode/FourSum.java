package ws.abhis.education.old.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> allQuads = new ArrayList<>();

        if (nums.length < 4) return allQuads;

        Arrays.sort(nums);

        for (int i=0; i<nums.length-3; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;

            for (int j=i+1; j<nums.length-2; ++j) {
                if (j>i+1 && nums[j] == nums[j-1]) continue;

                int l=j+1, r=nums.length-1;

                while (l < r) {
                    int sum = nums[i] + nums[j]  + nums[l] + nums[r];

                    if (sum == target) {
                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(nums[i]); a.add(nums[j]); a.add(nums[l]); a.add(nums[r]);
                        allQuads.add(a);

                        do {l++;} while (l<r && nums[l] == nums[l-1]);
                        do {r--;} while (l<r && nums[l] == nums[r+1]);
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return allQuads;
    }
}
