package ws.abhis.education.old;

/**
 * AP-6
 */
public class AP_6 {

    public boolean routeExists(Node start, Node end) {
        if (start == null) {
            return false;
        } else if (start == end) {
            return true;
        }

        return routeExists(start.left, end) || routeExists(start.right, end);
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

        System.out.println(new AP_6().routeExists(root, node1));
    }
}
