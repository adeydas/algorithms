package ws.abhis.education.old;

/**
 * Given a linked list, determine if it has a cycle in it.
 * Uses Flyod's cycle detection algorithm (https://adeydas.atlassian.net/wiki/display/AL/Flyod%27s+cycle+detection+algorithm)
 */
public class AP_36 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        //if no elements are there, there cannot be a cycle
        if (head == null)
            return false;

        //If its just one element, there cannot be a cycle
        if (head.next == null)
            return false;

        //If there are just two elements, we cannot apply Flyod's cycle detection algorithm, so check manually
        if (head.next.next == null) {
            if (head.next == head)
                return true;
            else
                return false;
        }


        ListNode slowPointer = head;
        ListNode fastPointer = head.next.next;

        while (slowPointer != null && fastPointer != null) {

            if (slowPointer == fastPointer)
                return true;

            slowPointer = slowPointer.next;

            //If we cannot increment fastPointer anymore and there we haven't hit true yet, it means there are no cycles
            if (fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
            } else {
                break;
            }
        }

        return false;
    }

    public ListNode init() {
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        three.next = four;
        ListNode two = new ListNode(2);
        two.next = three;
        ListNode one = new ListNode(1);
        one.next = two;
        four.next = two; //cycle

        return one;
    }

    public static void main(String... args) {
        AP_36 ap_36 = new AP_36();

        System.out.print(ap_36.hasCycle(ap_36.init()));
    }
}
