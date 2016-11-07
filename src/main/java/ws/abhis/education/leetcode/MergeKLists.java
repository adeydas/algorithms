package ws.abhis.education.leetcode;

import ws.abhis.education.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/95
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // start with a dummy node
        ListNode resultHead = new ListNode(0);
        ListNode resultIter = resultHead;

        /**
         * Insert the head nodes. This is the first level of prioritization / sorting.
         */
        for (ListNode list : lists) {
            if (null != list) {
                priorityQueue.offer(list);
            }
        }

        /**
         * This is the second level of insertion. Pull each member of each list and put in the
         * priority queue.
         */
        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            resultIter.next = temp;
            resultIter = resultIter.next;

            if (null != temp.next) {
                priorityQueue.offer(temp.next);
            }
        }

        return resultHead.next;
    }
}
