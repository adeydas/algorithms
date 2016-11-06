package ws.abhis.education.leetcode;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/92
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/93
 */
public class NumArray {
    private int[] tree;
    private int length;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            length = nums.length;
            tree = new int[length * 2]; // 2x since its a binary tree
            buildSegmentTree(nums);
        }
    }

    private void buildSegmentTree(int[] nums) {
        // fill the leaves
        for (int i = length, j = 0; i < 2 * length; i++, j++) {
            tree[i] = nums[j];
        }

        // fill the segments with value of the sum
        for (int i=length-1; i>0; --i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public int sumRange(int i, int j) {
        i = length + i;
        j = length + j;

        int sum = 0;
        while (i <= j) {
            if ((i % 2) == 1) {
                sum = sum + tree[i];
                i++;
            }
            if ((j % 2) == 0) {
                sum = sum + tree[j];
                j--;
            }
            i = i/2;
            j = j/2;
        }
        return sum;
    }

    void update(int i, int val) {
        i = i + length;
        tree[i] = val;

        while (i > 0) {
            int left = i;
            int right = i;

            if (i % 2 == 0) { // if left child
                right = i + 1;
            } else {
                left = i - 1;
            }

            // calculate parent
            tree[i/2] = tree[left] + tree[right];
            i = i/2;
        }
    }
}
