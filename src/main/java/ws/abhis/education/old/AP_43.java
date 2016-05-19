package ws.abhis.education.old;

/**
 * http://jira.abhis.ws/browse/AP-43
 */
public class AP_43 {

    /**
     * Insert a new element in a sorted LL. O(n) time solutions.
     * This implementation considers the array is sorted and there is always a place to insert the new element.
     * @param insert
     * @param root
     */
    public void insertElement(int insert, SinglyLLNode root) {
        SinglyLLNode slow = root;
        SinglyLLNode fast = root.next;
        boolean isInserted = false;

        while (!isInserted) {
            if (fast.value > insert) {
                SinglyLLNode newNode = new SinglyLLNode(insert, fast);
                slow.next = newNode;
                isInserted = true;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }

    public static void main(String... args) {
        /**
         * 1 -> 2 - > 3 -> 5
         *      |__________|
         */

        SinglyLLNode one = new SinglyLLNode(1, null);
        SinglyLLNode two = new SinglyLLNode(2, null);
        SinglyLLNode three = new SinglyLLNode(3, null);
        SinglyLLNode five = new SinglyLLNode(5, null);

        one.next = two;
        two.next = three;
        three.next = five;
        five.next = two;

        AP_43 ap_43 = new AP_43();
        ap_43.insertElement(4, one);
    }
}
