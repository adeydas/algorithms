package ws.abhis.education.leetcode;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/87
 */
public class LCABinTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.equals(p) || root.equals(q)) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }

        return l != null ? l : r;
    }
}
