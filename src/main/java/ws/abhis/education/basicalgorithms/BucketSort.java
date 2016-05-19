package ws.abhis.education.basicalgorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
  private static final int DEFAULT_BUCKET_SIZE = 5;

  public  void sort(int[] array) {
    sort(array, DEFAULT_BUCKET_SIZE);
  }

  private  void sort(int[] array, int defaultBucketSize) {
    // If array is empty, terminate
    if (array.length == 0) {
      return;
    }

    // Find the min and max values, bucket distribution would be based on that
    // Init to default min and max values
    int minValue = array[0];
    int maxValue = array[0];
    // Find the real min and max values
    for (int i=1; i<array.length; i++) {
      if (array[i] < minValue) {
        minValue = array[i];
      } else if (array[i] > maxValue) {
        maxValue = array[i];
      }
    }

    // Count the number of buckets
    int noOfBuckets = (maxValue - minValue) / defaultBucketSize + 1;
    // Init the buckets
    List<List<Integer>> buckets = new ArrayList<List<Integer>>(noOfBuckets);
    for (int i=0; i<noOfBuckets; i++) {
      buckets.add(new ArrayList<>());
    }

    // Distribute the elements into different buckets
    for (int i=0; i<array.length; i++) {
      // Find the bucket number
      int bucketNo = (array[i] - minValue) / defaultBucketSize;
      buckets.get(bucketNo).add(array[i]);
    }

    // Sort individual buckets
    for (int i=0; i<noOfBuckets; i++) {
      List<Integer> arr = buckets.get(i);
      Collections.sort(arr);
      buckets.set(i, arr);
    }

    // Stitch the buckets into a single array
    int index = 0;
    for (List<Integer> bucket : buckets) {
      for (Integer i : bucket) {
        array[index++] = i;
      }
    }

  }
}
