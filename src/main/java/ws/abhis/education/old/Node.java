package ws.abhis.education.old;

/**
 * Node of a binary tree
 */
public class Node {

    public Node(Object value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node() {}

    public Object value;
    public Node left;
    public Node right;
}
