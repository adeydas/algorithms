package ws.abhis.education.old;

/**
 * Created by abhishek on 3/22/15.
 * Website: adeydas.com
 */
public class BitNumber {
    public static String convert(int n) {
        if (n == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();

        while (n > 0) {
            if ((n & 1) == 1) {
                sb.append("A");
            } else {
                sb.append("B");
                n -= 1;
            }
            n >>= 1;
        }

        return sb.reverse().toString();
    }

    public static void main(String... args) {
        System.out.println( BitNumber.convert(8) );
    }
}
