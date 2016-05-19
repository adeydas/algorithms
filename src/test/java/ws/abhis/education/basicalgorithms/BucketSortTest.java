package ws.abhis.education.basicalgorithms;

import org.junit.Test;

public class BucketSortTest {
  @Test
  public void sort() throws Exception {
    int[] array = {4,1,9,0};
    BucketSort bucketSort = new BucketSort();
    bucketSort.sort(array);

    for (int i=0; i<array.length; i++) {
      System.out.println(array[i]);
    }
  }

}