package ws.abhis.education.leetcode;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/92
 */
public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;

        for (int k=i; k <= j; k++) {
            sum = sum + nums[k];
        }

        return sum;
    }
}
