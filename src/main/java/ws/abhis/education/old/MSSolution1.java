package ws.abhis.education.old;

import java.util.Stack;

/**
 * Created by abhishek on 3/11/15.
 * Website: adeydas.com
 */
public class MSSolution1 {

    //Time complexity: O(n), Space Complexity: O(n)
    public void printVertically(int i) {

        Stack<Integer> numbers = new Stack<Integer>();

        while (i>0) {
            //Pull each last number, put it in stack and reduce the number by the last digit.
            int lastNumber = i%10;
            numbers.push(lastNumber);
            i=i/10;
        }

        //Print out the stack.
        while (!numbers.isEmpty()) {
            System.out.println(numbers.pop());
        }
    }

    public static void main(String... args) {
        MSSolution1 msSolution1 = new MSSolution1();
        msSolution1.printVertically(123);
    }
}
