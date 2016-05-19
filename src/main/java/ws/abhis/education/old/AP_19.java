package ws.abhis.education.old;

/**
 * Given two trees T1 and T2, check whether T1 and T2 are mirror images of each other.
 */
public class AP_19 {

    public boolean isTreeMirror(Node node1, Node node2) {
        return check(node1.left, node2.right)  && check(node1.right, node2.left) ;
    }

    public boolean check(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1.value == node2.value)
            return true;
        else
            return false;
    }

    public static void main(String... args) {
        Node two = new Node(2, null, null);
        Node three = new Node(3, null, null);
        Node root1 = new Node(1, two, three);
        Node root2 = new Node(1, three, two);

        System.out.println(new AP_19().isTreeMirror(root1, root2));
    }
}
