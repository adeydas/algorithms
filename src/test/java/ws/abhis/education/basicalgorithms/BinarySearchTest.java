package ws.abhis.education.basicalgorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    private int[] sortedArray;
    private int numberToSearch;
    private BinarySearch binarySearch;

    @Before
    public void setup() {
        sortedArray = new int[4];
        sortedArray[0] = 1;
        sortedArray[1] = 2;
        sortedArray[2] = 3;
        sortedArray[3] = 4;

        numberToSearch = 3;

        binarySearch = new BinarySearch();
    }

    @Test
    public void testElementPresent() throws Exception {
        assertTrue(binarySearch.isElementPresent(sortedArray, numberToSearch));
    }

    @Test
    public void testElementNotPresent() throws Exception {
        assertFalse(binarySearch.isElementPresent(sortedArray, 10));
    }
}