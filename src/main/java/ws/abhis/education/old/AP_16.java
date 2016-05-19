package ws.abhis.education.old;

/**
 * Find the first or lowest common ancestor in a binary tree. Avoid storing additional nodes in a data structure.
 */
public class AP_16 {

    public Node findLCA(Node root, Node element1, Node element2) {
        if (root != null) {

            boolean isContains = (isContains(root.left, element1) && isContains(root.right, element2)) || (isContains(root.left, element2) && isContains(root.right, element1));
            if (isContains)
                return root;
            else {
                Node one = findLCA(root.left, element1, element2);
                Node two = findLCA(root.right, element1, element2);
                if (one != null)
                    return one;
                if (two != null)
                    return two;
            }

        }

        return null;
    }

    public boolean isContains(Node head, Node element) {
        if (head == null)
            return false;
        if (head == element)
            return true;
        return isContains(head.left, element) || isContains(head.right, element);
    }

    public static void main(String... args) {
        Node four = new Node(4, null, null);
        Node five = new Node(5, null, null);
        Node seven = new Node(7, null, null);
        Node two = new Node(2, four, five);
        Node three = new Node(3, null, seven);
        Node one = new Node(1, two, three);

        System.out.print( new AP_16().findLCA(one, four, seven).value );
    }
}
