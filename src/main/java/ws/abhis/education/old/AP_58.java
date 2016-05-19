package ws.abhis.education.old;

/**
 * http://jira.abhis.ws/browse/AP-58
 */
public class AP_58 {

    private int levelIndex = 0;

    public Node buildTree(int[] inOrder, int[] levelOrder, int start, int end) {


        Node node = new Node(levelOrder[levelIndex++], null, null);

        if (start >= end)
            return node;

        int index = findIndexInInorder((Integer)node.value, inOrder);

        node.left = buildTree(inOrder, levelOrder, start, index-1);
        node.right = buildTree(inOrder, levelOrder, index+1, end);

        return node;
    }

    private int findIndexInInorder(int levelOrderVal, int[] inOrder) {

        for (int i=0; i<inOrder.length; i++) {
            if (inOrder[i] == levelOrderVal) {
                if (i==0)
                    return i+1;
                else
                    return i;
            }

        }

        return -1;
    }

    public void printInOrder(Node root) {
        if (root == null)
            return;

        printInOrder(root.left);
        System.out.println(root.value);
        printInOrder(root.right);
    }

    public static void main(String... args) {
        int[] inOrder = {1,2,3};
        int[] levelOrder = {2,1,3};

        AP_58 ap_58 = new AP_58();
        Node root = ap_58.buildTree(inOrder, levelOrder, 0, inOrder.length-1);
        ap_58.printInOrder(root);
    }
}
