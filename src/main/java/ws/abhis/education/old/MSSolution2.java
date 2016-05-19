package ws.abhis.education.old;

/**
 * Created by abhishek on 3/11/15.
 * Website: adeydas.com
 */
public class MSSolution2 {

    public void makeNumbersMatch(int a, int b, int x, int y) {

        //&& should be || because the number of times required for a to reach x and b to y may be different
        while (a!=x || b!=y) {

            //if a has already reached x, this part of the computation is not required
            if (a!=x) {
                //if a is greater than x, decrement else increment
                if (a > x) {
                    a--;
                } else {
                    a++;
                }
            }


            //if b has already reached y, this part of the computation is not required
            if (b!=y) {

                //if b is greater than y, decrement else increment
                if (b > y) {
                    b--;
                } else {
                    b++;
                }
            }


        }
    }

    public static void main(String... args) {
        MSSolution2 msSolution2 = new MSSolution2();
        //msSolution2.makeNumbersMatch(5,4,1,12);
        msSolution2.makeNumbersMatch(4,5,12,1);
    }
}
