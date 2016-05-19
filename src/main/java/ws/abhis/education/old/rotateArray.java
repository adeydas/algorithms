package ws.abhis.education.old;

/**
 * Created by abhishek on 3/22/15.
 * Website: adeydas.com
 */
public class rotateArray {

    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        int n = A.length;
        int d = 2;
        rotateArr(A,0,d-1);
        rotateArr(A,d,n-1);
        rotateArr(A,0,n-1);

        for(int i=0;i<A.length;i++){
            System.out.print(A[i] + " ");
        }

    }

    private static void rotateArr(int[] a, int start, int end) {
        while(start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }



}
