package ws.abhis.education.old;

/**
 * http://jira.abhis.ws/browse/AP-25
 */
public class AP_25 {
    public int depth(Node root) {
        if (root == null)
            return -1;

        int left = depth(root.left);
        int right = depth(root.right);
        if (left > right)
            return left+1;
        else
            return right+1;
    }

    public static void main(String... args) {
        Node two = new Node(2, null, null);
        Node four = new Node(4, null, null);
        Node three = new Node(3, null, four);
        Node root = new Node(1, two, three);

        AP_25 ap_25 = new AP_25();
        System.out.print(ap_25.depth(root));
    }
}
