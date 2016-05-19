package ws.abhis.education.utils;

/**
 * Singly linked list node.
 */
public class SingleLinkedListNode implements Cloneable {
  private Object value;
  private SingleLinkedListNode nextNode;

  public SingleLinkedListNode(Object value, SingleLinkedListNode nextNode) {
    this.value = value;
    this.nextNode = nextNode;
  }

  public SingleLinkedListNode getNextNode() {
    return nextNode;
  }

  public void setNextNode(SingleLinkedListNode nextNode) {
    this.nextNode = nextNode;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public SingleLinkedListNode clone() {
    try {
      return (SingleLinkedListNode)super.clone();
    }
    catch (CloneNotSupportedException e) {
      return null;
    }
  }
}
