package ws.abhis.education.old;

import java.math.BigInteger;
import java.util.Random;

/**
 * Rabin Karp algorithm.
 */
public class Rabin_Karp {
    private String pattern; //the pattern.
    private long patternHash; //pattern hash value.
    private int patternLength; //length of the pattern or window size.
    private long Q; //a long prime to avoid overflow.
    private int R; //radix. Maximum variety of input characters.
    private long RM; //R ^ (M-1) % Q

    /**
     * Initialize vars. Pre-process pattern.
     * @param pattern
     */
    public Rabin_Karp(String pattern) {
        this.pattern = pattern;
        R = 256;
        this.patternLength = pattern.length();
        Q = randomPrime();

        //pre-process R^M-1 mod Q.
        RM = 1;
        for (int i=1; i<=patternLength-1; i++) {
            RM = (R * RM) % Q;
        }
        patternHash = hash(pattern, patternLength);
    }

    /**
     * Calculate hash from k[0...M-1].
     * @param k
     * @param M
     * @return long
     */
    private long hash(String k, int M) {
        long h = 0;
        for (int i=0; i<M; i++) {
            h = (R * h + k.charAt(i)) % Q;
        }
        return h;
    }

    /**
     * Return a 31-bit random prime.
     * @return long
     */
    private static long randomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    //pattern[] == text[i...i-M+1].
    private boolean check(String txt, int i) {
        for (int j=0; j<patternLength; j++) {
            if (pattern.charAt(j) != txt.charAt(i+j))
                return false;
        }
        return true;
    }

    /**
     * Search for the pattern.
     * Compute the text hash on a rolling basis.
     * If a match for the hash is found, check for all the characters.
     * The last part is not required for the algorithm but it helps avoid the spurious match issue.
     * @param text
     * @return int
     */
    public int search(String text) {
        int N = text.length();
        if (N < patternLength) return N; //text cannot be smaller than pattern.
        long textHash = hash(text, patternLength);

        //check for match at offset 0.
        if (patternHash == textHash && check(text, 0)) {
            return 0;
        }

        for (int i=patternLength; i<N; i++) {
            textHash = (textHash + Q - RM*text.charAt(i-patternLength) % Q) % Q;
            textHash = (textHash*R + text.charAt(i)) % Q;

            int offset = i-patternLength+1;
            if ((patternHash == textHash) && check(text, offset)) {
                return offset;
            }
        }
        return N;
    }

    public static void main(String... args) {
        Rabin_Karp rabin_karp = new Rabin_Karp("algo");
        System.out.println(rabin_karp.search("csalgorithms"));
    }
}
