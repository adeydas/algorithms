package ws.abhis.education.geeks4geeks;


import ws.abhis.education.utils.SingleLinkedListNode;

public class DeleteMidElementOfLinkedList {

  public void removeMidElement(SingleLinkedListNode singleLinkedListNode) {
    if (singleLinkedListNode == null) {
      return;
    }

    SingleLinkedListNode slowPointer = singleLinkedListNode;
    SingleLinkedListNode fastPointer = singleLinkedListNode;

    SingleLinkedListNode previousNode = null;

    while (null != fastPointer && fastPointer.getNextNode() != null) {
      fastPointer = fastPointer.getNextNode().getNextNode();
      previousNode = slowPointer;
      slowPointer = slowPointer.getNextNode();
    }

    previousNode.setNextNode(slowPointer.getNextNode());
  }
}
