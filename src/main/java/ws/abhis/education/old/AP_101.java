package ws.abhis.education.old;

/**
 * Find the second most repeating number in an array without using extra space.
 */
public class AP_101 {

    public int secondMostRepeating(int[] arr) {
        //check for null array or 0-length array.
        if (arr == null && arr.length == 0)
            return -1;

        int maxNumber = 0;
        int maxCount = 0;
        int secondMaxCount = 0;
        int secondMaxNumber = -1;

        for (int i=0; i<arr.length; i++) {
            int countHere = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[i] == arr[j])
                    countHere++;

            }

            /*
            If count is greater than max, replace max with count and second max with max.
            If count is between max and second max, replace second max with count.
             */
            if (countHere > maxCount) {
                secondMaxCount = maxCount;
                secondMaxNumber = maxNumber;
                maxCount = countHere;
                maxNumber = arr[i];
            } else if (countHere < maxCount && countHere > secondMaxCount) {
                secondMaxCount = countHere;
                secondMaxNumber = arr[i];
            }
        }
        return secondMaxNumber;
    }

    public static void main(String... args) {
        AP_101 ap_101 = new AP_101();
        //int[] arr = {1,1,2,2,2,3,4,5};
        int[] arr = {5,6,6};
        System.out.println(ap_101.secondMostRepeating(arr));
    }
}
