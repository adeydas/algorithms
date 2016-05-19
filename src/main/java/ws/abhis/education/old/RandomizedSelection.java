package ws.abhis.education.old;

/**
 * Randomized Selection.
 */
public class RandomizedSelection {

    public int randomSelection(int[] arr, int start, int end, int k) {
        if (start == end)
            return arr[start];

        if (k == 0)
            return -1;

        if (start < end) {
            int mid = new RandomizedPartition().randomPartition(arr,arr.length);

            int i=mid - start + 1;

            if (i==k)
                return arr[mid];
            else if (k < i)
                return randomSelection(arr, start, mid-1, k);
            else
                return randomSelection(arr, mid+1, end, k-i); //k-i worth of elements can only contains the k-mins.
        }

        return -1;
    }

    public static void main(String... args) {
        System.out.println(new RandomizedSelection().randomSelection(new int[] {9,5,7,1,10,2,3}, 0, 6, 2));
    }

}
