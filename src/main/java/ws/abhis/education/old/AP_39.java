package ws.abhis.education.old;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * http://jira.abhis.ws/browse/AP-39
 */
public class AP_39 {

    public int findMajorityElement(int[] elements) {
        Map<Integer, Integer> allIntegers = new HashMap<Integer, Integer>();

        //put all elements in map with count
        for (int i=0; i<elements.length; i++) {
            if (!allIntegers.containsKey(elements[i])) {
                allIntegers.put(elements[i], 1);
            } else {
                int counter = allIntegers.get(elements[i]);
                allIntegers.put(elements[i], ++counter);
            }
        }

        Iterator it = allIntegers.entrySet().iterator();
        int key = 0;
        int value = 0;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
            int k = entry.getKey();
            int v = entry.getValue();
            if (v > value) {
                value = v;
                key = k;
            }
        }

        return key;
    }

    public static void main(String... args) {
        int[] arr = {1,1,2,2,2,3,3,3,3,4};
        System.out.println(new AP_39().findMajorityElement(arr));
    }

}
