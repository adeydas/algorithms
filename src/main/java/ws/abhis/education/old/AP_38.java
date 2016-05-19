package ws.abhis.education.old;

import java.util.HashMap;
import java.util.Map;

/**
 * https://adeydas.atlassian.net/browse/AP-38
 */
public class AP_38 {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0)
            return null;


        int[] result = new int[2];

        //Put all numbers in a map with indexes as values
        Map<Integer, Integer> allNumbers = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++) {
            allNumbers.put(numbers[i], i);
        }

        //Check diff against map
        for (int i=0; i<numbers.length; i++) {
            int diff = target - numbers[i];
            if (allNumbers.containsKey(diff) && allNumbers.get(diff) != i) {

                int first = i;
                int second = findIndex(numbers, diff, -1);

                if (first == second) {
                    int third =findIndex(numbers, diff, first);
                    second = third;
                }

                first = ++first;
                second = ++second;

                if (first < second) {
                    result[0] = first;
                    result[1] = second;
                } else {
                    result[0] = second;
                    result[1] = first;
                }
                break;
            }
        }


        return result;
    }

    public int findIndex(int[] numbers, int target, int block) {
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == target) {
               if (block != -1) {
                   if (i != block)
                       return i;
                   else
                       block = -1;
               } else {
                   return i;
               }
            }
        }

        return -1;
    }

    public static void main(String... args) {
        int[] numbers = {2,1,9,4,4,56,90,3};
        int target = 8;

        AP_38 ap_38 = new AP_38();
        int[] result = ap_38.twoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]);


    }
}
