package ws.abhis.education.basicalgorithms;


public class MaximumSubarray {
  public  int maxSubArr(int[] arr) {
    int[] sum = new int[arr.length];
    int max = arr[0];

    sum[0] = arr[0];
    for (int i=1; i<arr.length; i++) {
      sum[i] = Math.max(arr[i], sum[i-1] + arr[i]);
      max = Math.max(max, sum[i]);
    }

    return max;
  }
}
