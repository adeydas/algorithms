package ws.abhis.education.old;

/**
 * Morris Inorder Traversal without stack.
 */
public class MorrisInorder {
        public void inOrder(TreeNode root) {
            TreeNode parent = root, tmp;
            while (null != parent) {
                if (null == parent.left) {
                    System.out.println(parent.val);
                    parent = parent.right;
                } else {
                    tmp = parent.left;
                    while (null != tmp.right && parent != tmp.right) {
                        tmp = tmp.right;
                    }
                    if (null == tmp.right) {
                        tmp.right = parent;
                        parent = parent.left;
                    } else {
                        System.out.println(parent.val);
                        tmp.right = null;
                        parent = parent.right;
                    }
                }
            }
        }

    public static void main(String... args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;

        MorrisInorder morrisInorder = new MorrisInorder();
        morrisInorder.inOrder(one);
    }
}
