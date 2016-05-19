package ws.abhis.education.old;

/**
 * AP-5
 */
public class AP_5 {

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int diff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(diff) > 1) {
            return false;
        } else {
            boolean leftSubtree = isBalanced(root.left);
            boolean rightSubtree = isBalanced(root.right);
            if (leftSubtree && rightSubtree) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String... args) {
        Node node1 = new Node();
        node1.value = (Object)1;
        node1.left = null;
        node1.right = null;

        Node node2 = new Node();
        node2.value = (Object)2;
        node2.left = null;
        node2.right = null;

        Node root = new Node();
        root.value = (Object)3;
        root.left = node1;
        root.right = node2;

        System.out.println(new AP_5().isBalanced(root));
    }
}
