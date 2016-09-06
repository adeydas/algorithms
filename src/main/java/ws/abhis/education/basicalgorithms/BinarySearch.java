package ws.abhis.education.basicalgorithms;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/65
 */
public class BinarySearch {

    private int search(int[] sortedArray, int numberToSearch) {
        int startIndex = 0;
        int endIndex = sortedArray.length-1;

        while (startIndex < endIndex) {
            final int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (numberToSearch > sortedArray[midIndex]) {
                startIndex = midIndex + 1;
            } else if (numberToSearch < sortedArray[midIndex]) {
                endIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }

        return -1;
    }

    public boolean isElementPresent(int[] sortedArray, int numberToSearch) {
        int index = search(sortedArray, numberToSearch);

        return index==-1?false:true;
    }
}
