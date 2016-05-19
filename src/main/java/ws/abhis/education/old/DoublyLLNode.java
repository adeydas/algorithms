package ws.abhis.education.old;

/**
 * Doubly Linkedlist node.
 */
public class DoublyLLNode {
    public int value;
    public DoublyLLNode left;
    public DoublyLLNode right;

    public DoublyLLNode(int value, DoublyLLNode left, DoublyLLNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
