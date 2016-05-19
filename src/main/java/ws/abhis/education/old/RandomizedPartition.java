package ws.abhis.education.old;

/**
 * Randomized Partition algorithm.
 */
public class RandomizedPartition {

    public int randomPartition(int[] arr, int size) {
        double d = (Math.random() * (size-1));
        int pivotIndex = (int) (d);
        System.out.println("Random pivot index " + pivotIndex);
        int pivot = arr[pivotIndex];
        int i=-1;
        int j=0;
        swap(arr, pivotIndex, size-1);
        pivotIndex = size-1;

        while (j<size) {
            if (arr[j] <= pivot) {
                i=i+1;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i+1, pivotIndex);
        //printArray(arr);
        return i+1;
    }

    public void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String... args) {
        int[] arr = {9,5,7,1,2,3};
        int pivot = new RandomizedPartition().randomPartition( arr, 6 );
        System.out.println(pivot);
    }

}
