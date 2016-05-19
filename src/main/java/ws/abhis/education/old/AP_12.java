package ws.abhis.education.old;

import java.util.LinkedList;

/**
 * Post-Order Traversal (Left - Right - Root)
 */
public class AP_12 {

    public void postOrderRecurse(Node root) {
        if (root == null)
            return;

        //Traverse the left sub-tree
        postOrderRecurse(root.left);
        //Traverse the right sub-tree
        postOrderRecurse(root.right);
        //Print the node
        System.out.println(root.value);
    }

    public void postOrderIterative(Node head) {
        if (head == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<Node>();
        stack.push(head);

        while (!stack.isEmpty()) {
            Node next = stack.peek();

            boolean finishedSubtrees = (next.right == head || next.left == head);
            boolean isLeaf = (next.left == null && next.right == null);
            if (finishedSubtrees || isLeaf) {
                stack.pop();
                System.out.println(next.value);
                head = next;
            }
            else {
                if (next.right != null) {
                    stack.push(next.right);
                }
                if (next.left != null) {
                    stack.push(next.left);
                }
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

        new AP_12().postOrderRecurse(root);
        new AP_12().postOrderIterative(root);
    }
}
