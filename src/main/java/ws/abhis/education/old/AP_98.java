package ws.abhis.education.old;

/**
 * Given an array of strings {"abc", "be"}, print in the following order using constant space.
 a b
 b e
 c
 */
public class AP_98 {

    public void printVertically(String[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int maxLength = findStringWithGreatestLength(arr);

        for (int i=0; i<maxLength; i++) {
            for (int j=0; j<arr.length; j++) {
                if (i<arr[j].length())
                    System.out.print(arr[j].charAt(i) + "\t");
            }
            System.out.println();
        }
    }

   private int findStringWithGreatestLength(String[] arr) {
       int maxLength = Integer.MIN_VALUE;
       for (int i=0; i<arr.length; i++) {
           String s = arr[i];
           if (s.length() > maxLength)
               maxLength = s.length();
       }
       return maxLength;
   }

    public static void main(String... args) {
        AP_98 ap_98 = new AP_98();
        String[] arr = new String[] {"abc", "be"};

        ap_98.printVertically(arr);
    }
}
