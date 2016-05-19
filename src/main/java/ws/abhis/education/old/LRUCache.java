package ws.abhis.education.old;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * AP-75
 */
public class LRUCache {

    public class Node {
        public int address; //address of the node.
        public int value; //value stored.

        public Node(int address, int value) {
            this.address = address;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public Node prev;
        public Node next;
    }

    private int capacity; //Length of the LRU Cache.
    private int length; //Current length of queue.
    private Node queue; //queue to hold the nodes, node indicates the head node.
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //Map to hold key to address relation.

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * Method to set a key and its corresponding value.
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        int address = (key + value)*31; //Randomly calculate an address.
        addKey(key, value, address);
    }

    /**
     * Add the key, address and value to map and queue.
     * @param key
     * @param value
     * @param address
     */
    private void addKey(int key, int value, int address) {
        Node node = new Node(address, value);
        if (length==0) {
            //queue is empty, put as head.
            queue = node;
            map.put(key, address);
            length++;
        } else {
            //queue is not empty, put at the top if space left, else remove one from last and put at top.
            if (length == capacity) {
                removeOneFromLast();
            }
            queue.prev = node;
            node.next = queue;
            queue = node;
            map.put(key, address);
            length++;
        }
    }

    /**
     * Clears up a space at the end.
     */
    private void removeOneFromLast() {
        while ((queue = queue.next).next != null); //move the queue pointer to the second last element.
        Node temp = queue;
        queue = queue.prev;
        queue.next = null;
        while ((queue = queue.prev).prev != null); //move the queue pointer to the head element.
        Iterator it = map.entrySet().iterator();
        int key = -1;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>) it.next();
            if (e.getValue() == temp.address) {
                key = e.getKey();
            }
        }
        map.remove(key);
        length--;
    }

    /**
     * Method to get the value of a key.
     * @param key
     * @return int
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int address = map.get(key);
        while (queue.next != null) {
            if (queue.address == address) {
                Node temp = queue;
                queue.prev.next = queue.next;
                while ((queue = queue.prev).prev != null);
                temp.next = queue;
                queue.prev = temp;
                queue = temp;
                return temp.value;
            }
            queue = queue.next;
        }

        return -1;
    }

    public void printCacheContents() {
        Node temp = queue;
        while ( temp != null) {
            System.out.println(temp.address + "\t" + temp.value);
            temp = temp.next;
        }
    }

    public void printMapContents() {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>) it.next();
            System.out.println(e.getKey() + "\t" + e.getValue());
        }
    }

    public static void main(String... args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.set(1, 10);
        lruCache.set(2, 20);
        lruCache.set(4, 30);
        lruCache.set(6, 40);
        lruCache.set(9, 50);
        lruCache.set(12, 60); //the cache cycles at this point.

        lruCache.printCacheContents();
        //lruCache.printMapContents();

        System.out.println(lruCache.get(9));

        lruCache.printCacheContents();
        //lruCache.printMapContents();
    }

}
