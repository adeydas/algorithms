package ws.abhis.education.old;

/**
 * Given an array of integers when the difference between every two neighboring elements is either -1 or +1 or 0.
 Write an efficient search algorithm to find a given number x in the array.
 */
public class AP_23 {

    public int findElement(int[] arr, int element) {

       for (int i=0; i<arr.length; i++) {
           if (arr[i] == element)
               return i;
           else {
               int diff = Math.abs(arr[i]-element);
               int minHops = diff;
               i = i+minHops;
           }
       }

        return -1;
    }

    public static void main(String... args) {
        int[] arr = {2,3,3,2,1,1,0,-1};


        System.out.print(new AP_23().findElement(arr, 3));
    }
}
