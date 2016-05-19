package ws.abhis.education.old.geeks4geeks;

/**
 * Given an integer, write a function that calculates ?7n/8? (ceiling of 7n/8) without using division and multiplication operators.
 */
public class Calculate7nby8 {

    public int multiplyBySevenByEight( int n) {
        return n - (n>>3); //n>>3 calculates floor of n/8
    }
}
