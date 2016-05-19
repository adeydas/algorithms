package ws.abhis.education.old;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class AP_9 {

    public boolean isBinaryTreeABST(Node head) {
        if (head != null) {
            if (head.left != null) {
                if ((Integer) head.left.value > (Integer) head.value) return false;
            }
            if (head.right != null) {
                if ((Integer) head.right.value < (Integer) head.value) return false;
            }
        }

        if (head.left != null)
            isBinaryTreeABST(head.left) ;
        if (head.right != null)
            isBinaryTreeABST(head.right);

        return true;

    }

    public static void main(String... args) {
        Node node1 = new Node();
        node1.value = (Object)1;
        node1.left = null;
        node1.right = null;

        Node node2 = new Node();
        node2.value = (Object)4;
        node2.left = null;
        node2.right = null;

        Node root = new Node();
        root.value = (Object)3;
        root.left = node1;
        root.right = node2;

        System.out.println(new AP_9().isBinaryTreeABST(root));

    }
}
