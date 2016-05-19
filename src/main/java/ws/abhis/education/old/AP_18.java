package ws.abhis.education.old;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, print all paths which sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go in a straight line down.
 */
public class AP_18 {

    private List<List<Node>> allOfThem = new ArrayList<List<Node>>();

    public void printPath(Node head, int sum, int[] path, int level) {
        //If the node is null, terminate
        if (head == null) return;

        //Current node goes in path
        path[level] = (Integer)head.value;

        //Look for paths with a sum that ends in this node
        int tempSum = 0;
        for (int i=level; i>=0; i--) {
            tempSum += path[i];
            if (tempSum == sum)
                write(path, i, level);
        }

        //Search for other nodes
        printPath(head.left, sum, path, level + 1);
        printPath(head.right, sum, path, level + 1);
    }

    private void write(int[] path, int i, int level) {
        for (int j=i; j <= level; j++) {
            System.out.println(path[j]);
        }
    }

    public static void main(String... args) {
        Node eight = new Node(8, null, null);
        Node nine = new Node(9, null, null);
        Node ten = new Node(10, null, null);
        Node twelve = new Node(12, null, null);
        Node four = new Node(4, eight, nine);
        Node six = new Node(6, null, ten);
        Node two = new Node (2, four, six);
        Node seven = new Node(7, null, twelve);
        Node five = new Node(5, null, null);
        Node three = new Node(3, five, seven);
        Node root = new Node(1, two, three);

        AP_18 ap_18 = new AP_18();

        ap_18.printPath(root, 10, new int[99], 0);
        System.out.println(ap_18.allOfThem.size());
    }
}
