package ws.abhis.education.old;

/**
 * Created by abhishek on 3/11/15.
 * Website: adeydas.com
 */
public class MSSolution3 {

    public void findCorrupt(MySinglyLinkedList head) {
        MySinglyLinkedList tortoise = head;
        MySinglyLinkedList hare = head.nextNode;
        while (tortoise != hare) {
            tortoise = tortoise.nextNode;
            hare = hare.nextNode;
        }
        System.out.println(tortoise.value);
    }



    public int hasLoop(MySinglyLinkedList first) {

        if(first == null) // list does not exist..so no loop either.
            return 0;

        MySinglyLinkedList slow, fast; // create two references.

        slow = fast = first; // make both refer to the start of the list.



        while(true) {

            slow = slow.nextNode;          // 1 hop.

            if(fast.nextNode != null)
                fast = fast.nextNode.nextNode; // 2 hops.
            else
                return 0;          // next node null => no loop.

            if(slow == null || fast == null) // if either hits null..no loop.
                return 0;

            if(slow == fast) { // if the two ever meet...we must have a loop.

                int cnt = 1;
                slow = slow.nextNode;
                StringBuffer buffer = new StringBuffer();
                while (slow != fast) {
                    buffer.append(slow.value);
                    cnt++;
                    slow = slow.nextNode;
                }
                buffer.append(fast.value);

                String t = cnt + buffer.toString();



                return Integer.parseInt(t);
            }


        }
    }

    public static void main(String[] args) {
        MSSolution3 obj = new MSSolution3();

        obj.test1();
        obj.test2();
        obj.test3();
        obj.test4();
        obj.test5();
    }

    //Test with 1-2-3 and a loop back from 3 to 1
    public void test1() {
        MSSolution3 obj = new MSSolution3();

        MySinglyLinkedList two = new MySinglyLinkedList(2, null);

        MySinglyLinkedList head = new MySinglyLinkedList(1, two);

        MySinglyLinkedList three = new MySinglyLinkedList(3, head);


        two.nextNode = three;
        System.out.println(obj.hasLoop(head));
    }

    //Test for a null linked list
    public void test2() {
        MSSolution3 obj = new MSSolution3();

        MySinglyLinkedList head = null;
        System.out.println(obj.hasLoop(head));
    }

    //Test with one node
    public void test3() {
        MSSolution3 obj = new MSSolution3();

        MySinglyLinkedList head = new MySinglyLinkedList(1, null);
        System.out.println(obj.hasLoop(head));
    }

    //Test with one node with a self loop
    public void test4() {
        MSSolution3 obj = new MSSolution3();

        MySinglyLinkedList head = new MySinglyLinkedList(1, null);
        head.nextNode = head;
        System.out.println(obj.hasLoop(head));
    }

    //Test with 1-2-3-4 and a loop back from 3
    public void test5() {
        MSSolution3 obj = new MSSolution3();


        MySinglyLinkedList four = new MySinglyLinkedList(4, null);

        MySinglyLinkedList two = new MySinglyLinkedList(2, new MySinglyLinkedList(3, four));

        MySinglyLinkedList head = new MySinglyLinkedList(1, two);


        four.nextNode = two;


        System.out.println(obj.hasLoop(head));
    }
}
