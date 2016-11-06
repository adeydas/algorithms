package ws.abhis.education.leetcode;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/88
 */
public class PowerCalc {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = myPow(x, n/2);

        if (x % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }
}
