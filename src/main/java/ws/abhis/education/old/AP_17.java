package ws.abhis.education.old;

/**
 * Write an algorithm to determine whether T2 is a subtree of T1.
 */
public class AP_17 {

    public boolean findMatch(Node T1, Node T2) {

        if (T1 != null && T2 != null) {

            if (T1.value == T2.value) {
                return checkIfSubTree(T1, T2);
            } else {
                return findMatch(T1.left, T2) || findMatch(T1.right, T2);

            }
        }

        return false;
    }

    public boolean checkIfSubTree(Node T1, Node T2) {

        if (T1 == null && T2 == null)
            return true;

        if (T1 == null && T2 != null)
            return false;

        if (T1 != null && T2 == null)
            return false;


        if (T1.value == T2.value) {
            checkIfSubTree(T1.left, T2.left);
            checkIfSubTree(T1.right, T2.right);
        } else {
            return false;
        }

        return true;
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

       AP_17 ap_17 = new AP_17();
       System.out.println(ap_17.findMatch(root, two));
    }

}
