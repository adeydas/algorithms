package ws.abhis.education.old;

/**
 * Red Black trees
 */
public class AP_27 {
    public class RBNode {
        public Integer value;
        public boolean isRed;
        public RBNode left;
        public RBNode right;
        public RBNode parent;

        public RBNode(Integer value) {
            this.value = value;
            this.isRed = false;
            this.left = null;
            this.right = null;
        }

        public RBNode(){}
    }

    /**
     * Finds the grandfather.
     * @param node
     * @return RBNode
     */
    public RBNode findGrandfather(RBNode node) {
        return node.parent.parent;
    }

    /**
     * Finds the uncle.
     * @param node
     * @return RBNode
     */
    public RBNode findUncle(RBNode node) {
        RBNode grandfather = node.parent.parent;
        if (grandfather == null) {
            //no grandpa, no unca
            return null;
        }
        else {
            if (grandfather.left == node) {
                return grandfather.right;
            } else {
                return grandfather.left;
            }
        }
    }

    /**
     * If node is root.
     * @param node
     * @return
     */
    public void insertNode1(RBNode node) {
        if(node.parent == null) {
            node.isRed = false; //re-paint to BLACK

        } else {
            insertNode2(node);
        }
    }

    /**
     * If node is black.
     * @param node
     * @return
     */
    public void insertNode2(RBNode node) {
        if (!node.parent.isRed) {
            return;
        } else {
            insertNode3(node);
        }
    }

    /**
     * If parent and uncle are red.
     * @param node
     * @return
     */
    public void insertNode3(RBNode node) {
        RBNode uncle = findUncle(node);

        if (uncle!= null && uncle.isRed) {
            node.parent.isRed = false; //re-paint parent BLACK
            uncle.isRed = false; //re-paint uncle BLACK
            RBNode grandfather = findGrandfather(node);
            grandfather.isRed = true;
            insertNode1(grandfather);
        } else {
            insertNode4(node);
        }
    }

    /**
     * If parent is RED, uncle BLACK and N is the right child of its parent
     * @param node
     */
    public void insertNode4(RBNode node) {
        RBNode grandfather = findGrandfather(node);
        if (node.parent.right == node && node.parent == grandfather.left) {
            rotate_left(node.parent);
            node = node.left;
        } else if (node==node.parent.left && node.parent == grandfather.right) {
            rotate_right(node.parent);
            node = node.right;
        }

        insertNode5(node);
    }

    /**
     * If parent is RED, uncle BLACK and N is the left child of its parent
     * @param node
     */
    public void insertNode5(RBNode node) {
        RBNode grandfather = findGrandfather(node);
        node.parent.isRed = false; //re-paint parent to black
        grandfather.isRed = true;

        if (node == node.parent.left) {
            rotate_right(grandfather);
        } else {
            rotate_left(grandfather);
        }
    }

    /**
     * Left rotation
     * @param node
     */
    public void rotate_left(RBNode node) {
        node.left = node.parent;
        node.parent.right = node.left;
        node.parent.parent.left = node;
    }

    /**
     * Right rotation
     * @param node
     */
    public void rotate_right(RBNode node) {
        node.left = node.left.left;
        node.left.right = node;
    }

}
