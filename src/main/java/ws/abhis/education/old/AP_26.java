package ws.abhis.education.old;

/**
 * AVL Trees
 */
public class AP_26 {

    private int leftDepth;
    private int rightDepth;

    /**
     * BST insert augmented with AVL balance
     * @param start
     * @param root
     * @param value
     */
    public void BSTInsert(Node start, Node root, int value) {
        if (root == null) return;


        int nodeVal = (Integer)root.value;
        if (value < nodeVal) {
            if (root.left == null) {
                Node node = new Node(value, null, null);
                root.left = node;
                reOrganize(start, root);
            } else {
                BSTInsert(start, root.left, value);
            }
        } else  {
            if (root.right == null) {
                Node node = new Node(value, null, null);
                root.right = node;
                reOrganize(start, root);
            } else {
                BSTInsert(start, root.right, value);
            }
        }
    }

    /**
     * Replace a matching child
     * @param fixedNode
     * @param compareNode
     * @param replaceNode
     */
    public void replace(Node fixedNode, Node compareNode , Node replaceNode) {
        if (fixedNode.left == compareNode) {
            fixedNode.left = replaceNode;
        } else {
            fixedNode.right = replaceNode;
        }
    }

    /**
     * Find the minimum in a BST
     * @param root
     * @return
     */
    public Node findMinimum(Node root) {
        if (root.left == null && root.right == null)
            return root;
        return findMinimum(root.left);
    }

    /**
     * BST delete augmented with AVL balance
     * @param start
     * @param root
     * @param value
     */
    public void BSTDelete(Node start, Node root, Node value) {
        Node parent = new Node();
        parent = findParent(root, value, parent);

        //if the node is a leaf
        if (value.left == null && value.right == null) {
            //remove without consequences
            replace(parent, value, null);
            reOrganize(start, root);
        }

        //if the node has one sub-tree(left or right), delete the node and connect the subtree to parent
        if ( (value.left == null && value.right != null) || (value.left != null && value.right == null) ) {
            if (value.left == null) {
                replace(parent, value, value.right);
                reOrganize(start, root);
            } else {
                replace(parent, value, value.left);
                reOrganize(start, root);
            }
        }

        //if the node has both subtrees, replace the node with the minimum element in the right subtree
        if (value.left != null && value.right != null) {
            Node minimum = findMinimum(value.right);
            BSTDelete(start, root, minimum);
            value.value = minimum.value;
        }
    }

    /**
     * Find depth of tree
     * @param root
     * @return
     */
    public int depth(Node root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        this.leftDepth = left;
        this.rightDepth = right;
        return left > right? ++left : ++right;
    }

    /**
     * Check whether reorganization is required
     * @param root
     * @return
     */
    public boolean isReOrganizingRequired(Node root) {
        if (root == null) return false;
        int left = depth(root.left);
        int right = depth(root.right);
        int diff = Math.abs(right-left);
        if (diff > 1)
            return true;
        else
            return false;
    }

    /**
     * Find the parent of a node
     * @param root
     * @param element
     * @param parent
     * @return
     */
    public Node findParent(Node root, Node element, Node parent) {
        if (root == null) return null;

        int rootValue = (Integer)root.value;
        int elementValue = (Integer)element.value;

        if (root.left.value == element.value || root.right.value == element.value) {
            parent = root;
            return root;
        } else {
            if (elementValue < rootValue) {
                return findParent(root.left, element, parent);
            } else {
                return findParent(root.right, element, parent);
            }
        }


    }

    /**
     * Single left rotate
     * @param start
     * @param root
     */
    public void leftRotation(Node start, Node root) {
        Node rightChild = root.right;
        Node rightGrandChild = root.right.right;
        Node parent = new Node();
        parent = findParent(start, root, parent);

        parent.right =  rightGrandChild;
        BSTInsert(start, root.right.right.left, (Integer)root.value);
        BSTInsert(start, root.right.right.right, (Integer)rightChild.value);
    }

    /**
     * Single right rotate
     * @param start
     * @param root
     */
    public void rightRotation(Node start, Node root) {

        if (root == null || root.left == null || root.left.left == null) return;

        Node leftChild = root.left;
        Node leftGrandChild = root.left.left ;
        Node parent = new Node();
        parent = findParent(start, root, parent);

        parent.left = leftGrandChild;
        BSTInsert(start, root.left.left.left, (Integer)leftChild.value);
        BSTInsert(start, root.left.left.right, (Integer)root.value);
    }

    /**
     * Rotate logic
     * @param start
     * @param root
     */
    public void reOrganize(Node start, Node root) {
        boolean isRequired = isReOrganizingRequired(root);
        if (isRequired) {
            if (this.rightDepth > this.leftDepth) {
                //tree is right heavy
                Node child = root.right;
                isReOrganizingRequired(child);
                if (this.leftDepth > this.rightDepth) {
                    //right subtree is left heavy, perform double left rotation
                    rightRotation(start, root.left);
                    leftRotation(start, root);
                } else {
                    //right subtree is right heavy, perform left rotation
                    leftRotation(start, root);
                }
            } else {
                //tree is left heavy
                Node child = root.left;
                isReOrganizingRequired(child);
                if (this.rightDepth > this.leftDepth) {
                    //left subtree is right heavy, perform double right rotation
                    leftRotation(start, root.right);
                    rightRotation(start, root);
                } else {
                    //left subtree is left heavy, perform right rotation
                    rightRotation(start, root);
                }
            }
        }
    }

    /**
     * Print inOrder
     * @param root
     */
    public void printInOrder(Node root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    /**
     * Print preorder
     * @param root
     */
    public void printPreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }


    public static void main(String... args) {
        Node nFour = new Node(-4, null, null);
        Node three = new Node(3, null, null);
        Node two = new Node(2, nFour, three);
        Node eighteen = new Node(18, null, null);
        Node five = new Node(5, two, eighteen);

        AP_26 ap_26 = new AP_26();
        ap_26.BSTInsert(five, five, 19);
        ap_26.BSTInsert(five, five, 20);
        System.out.println();
        ap_26.printPreOrder(five);
        ap_26.BSTDelete(five, five, three);
        System.out.println();
        ap_26.printInOrder(five);

    }
}
