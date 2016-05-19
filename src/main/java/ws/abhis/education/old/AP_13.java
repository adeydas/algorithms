package ws.abhis.education.old;

import java.util.LinkedList;

/**
 * In-Order Traversal (Left - Root - Right)
 */
public class AP_13 {

    public void inOrderRecurse(Node head) {
        if (head == null) return;

        inOrderRecurse(head.left);
        System.out.println(head.value);
        inOrderRecurse(head.right);
    }

    public void inOrderIterative(Node head) {
        LinkedList<Node> stack = new LinkedList<Node>();


        while (!stack.isEmpty() || head != null) {
           if (head != null) {
               stack.push(head);
               head = head.left;
           } else {
               head = stack.pop();
               System.out.println(head.value);
               head = head.right;
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

        new AP_13().inOrderRecurse(root);
        new AP_13().inOrderIterative(root);
    }
}
