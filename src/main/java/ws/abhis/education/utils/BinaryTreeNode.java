package ws.abhis.education.utils;


public class BinaryTreeNode {
  private Object value;
  private BinaryTreeNode leftChild;
  private BinaryTreeNode rightChild;

  public BinaryTreeNode(Object value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.value = value;
  }

  public BinaryTreeNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(BinaryTreeNode rightChild) {
    this.rightChild = rightChild;
  }

  public BinaryTreeNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BinaryTreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }
}
