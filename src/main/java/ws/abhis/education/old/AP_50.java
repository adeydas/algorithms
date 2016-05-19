package ws.abhis.education.old;

/**
 * http://jira.abhis.ws/browse/AP-50
 */
public class AP_50 {

    public void printLeaves(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.value);
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void main(String... args) {

        /**
         *              20
         *          8       22
         *       4     12
         *          10   14
         */

        Node root = new Node(20, new Node(8, new Node(4, null, null), new Node(12, new Node(10, null, null), new Node(14, null, null))), new Node(22, null, null));

        AP_50 ap_50 = new AP_50();
        ap_50.printLeaves(root);
    }

}
