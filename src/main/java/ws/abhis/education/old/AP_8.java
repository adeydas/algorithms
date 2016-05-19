package ws.abhis.education.old;

import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of
 * all the nodes at each depth (e.g. if you have a tree with depth D, you'll have D linked lists).
 */
public class AP_8 {

    public LinkedList<LinkedList<Node>> allLists = new LinkedList<LinkedList<Node>>();

    public void preProcess(Node root) {
        int depth = findDepth(root);

        for (int i=0; i<depth; i++) {
            allLists.add(new LinkedList<Node>());
        }
    }

    public class AP8Datatype {
        public Node node;
        public int level;

        public AP8Datatype(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void formLists(Node root) {
        LinkedList<AP8Datatype> stack = new LinkedList<AP8Datatype>();

        stack.push(new AP8Datatype(root, 0));



        while (!stack.isEmpty()) {
            AP8Datatype temp = stack.pop();



            allLists.get(temp.level).add(temp.node);

            if (temp.node.left != null || temp.node.right != null) {
                int newlevel = temp.level+1;
                if (temp.node.left != null) {
                    stack.push( new AP8Datatype(temp.node.left, newlevel) );
                }
                if (temp.node.right != null) {
                    stack.push( new AP8Datatype(temp.node.right, newlevel));
                }
            }
        }
    }

    public int findDepth(Node root) {

        if (root == null)
            return 0;

        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return left > right ? left + 1 : right + 1;
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

        AP_8 ap_8 = new AP_8();
        ap_8.preProcess(root);
        ap_8.formLists(root);

        for (int i=0; i<ap_8.allLists.size(); i++) {
            LinkedList<Node> temp = ap_8.allLists.get(i);
            for (int j=0; j<temp.size(); j++) {
                System.out.println(temp.get(j).value);
            }
            System.out.println("========================");
        }
    }
}
