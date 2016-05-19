package ws.abhis.education.old;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth first search
 */
public class AP_1 {

    public void BFS(Node head) {
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.element();
            queue.remove();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
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

        new AP_1().BFS(root);
    }
}
