package ws.abhis.education.utils;

public class IntegerTreeNode {

  public IntegerTreeNode(int value, IntegerTreeNode leftChild, IntegerTreeNode rightChild) {
    this.value = value;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  private int value;
  private IntegerTreeNode leftChild;
  private IntegerTreeNode rightChild;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public IntegerTreeNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(IntegerTreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public IntegerTreeNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(IntegerTreeNode rightChild) {
    this.rightChild = rightChild;
  }
}
