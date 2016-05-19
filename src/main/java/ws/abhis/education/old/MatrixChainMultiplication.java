package ws.abhis.education.old;

/**
 * Created by abhishek on 3/20/15.
 * Website: adeydas.com
 */
public class MatrixChainMultiplication {

    public int costOfMultTwoMatrics(int[][] matrix1, int[][] matrix2) {
        //if matrix1.cols != matrix2.rows, return error
        if (matrix1[0].length != matrix2.length) {
            return -1;
        }

        int[][] result = new int[matrix1.length][matrix2[0].length]; //new result matrix with matrix1.rows and matrix2.cols

        for (int i=0; i<matrix1.length; i++) { //iterate matrix1 rows

        }
        return -1;
    }

}
