package ws.abhis.education.leetcode;

import ws.abhis.education.utils.TreeNode;

import java.util.*;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/90
 */
public class BTLevelOrderTraverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        if (root == null) {
            return finalList;
        }

        // enqueue the first node
        queue.add(root);

        while (!queue.isEmpty()) {

            // dequeue the entire level
            int nodeCount = queue.size();
            while (nodeCount > 0) {
                TreeNode val = queue.remove();
                intList.add(val.val);

                // enqueue for the next level
                if (val.left != null) {
                    queue.add(val.left);
                }
                if (val.right != null) {
                    queue.add(val.right);
                }

                nodeCount--;
            }
            finalList.add(intList);
            intList.clear();
        }

        return finalList;
    }
}
