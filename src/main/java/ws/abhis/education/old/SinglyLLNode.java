package ws.abhis.education.old;

/**
 * Singly LinkedList Node
 */
public class SinglyLLNode {
    public int value;
    public SinglyLLNode next;

    public SinglyLLNode(int value) {
        this.value = value;
        this.next = null;
    }

    public SinglyLLNode(int value, SinglyLLNode next) {
        this.value = value;
        this.next = next;
    }

    public SinglyLLNode(){}
}
