package ws.abhis.education.leetcode;

import java.util.Random;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/94
 */
public class RandomPickIndex {

    private int[] nums;
    private Random r = new Random();

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int ret = -1;
        if (nums == null) {
            return ret;
        }
        int upbound = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (r.nextInt(upbound) == 0) {
                    ret = i;
                }
                upbound++;
            }
        }
        return ret;
    }
}
