package ws.abhis.education.basicalgorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubarrayTest {
  @Test
  public void maxSubArr() throws Exception {
    int[] arr = {2,1,-3,4,-1,2,1,-5,4};
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    assertEquals(maximumSubarray.maxSubArr(arr), 6);
  }

}