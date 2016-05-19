package ws.abhis.education.old;

import java.util.Random;

/**
 * https://softengr2015.files.wordpress.com/2015/05/img_0015.pdf
 * https://softengr2015.files.wordpress.com/2015/05/img_0016.pdf
 */
public class PrimalityTest {

    //calculate a^b % c.
    private long modulo(long a, long b, long c) {
        long x=1, y=a;
        while (b>0) {
            if (b%2==1) {
                x=(x*y)%c;
            }
            y=(y*y)%c;
            b/=2;
        }
        return x%c;
    }

    //calculate a*b %c.
    public long mmodulo(long a, long b, long c) {
        long x=0, y=a%c;
        while (b>0) {
            if (b%2==1) {
                x=(x+y)%c;
            }
            y=(y*2)%c;
            b/=2;
        }
        return x%c;
    }

    public boolean rabinMiller(long p, int iterations) {
        if (p<2)
            return false;
        if (p!=2 && p%2==0)
            return false;
        long s=p-1;
        while (s%2==0) {
            s/=2;
        }
        for (int i=0; i<iterations; i++) {
            long random=new Random().nextInt()%(p-1)+1, temp=s;
            long mod = modulo(random, temp, p);
            while (temp!=p-1 && mod!=1 && mod!=p-1) {
                mod = mmodulo(mod, mod, p);
                temp *=2;
            }
            if (mod!=p-1 && temp%2==0)
                return false;
        }
        return true;
    }

    public boolean fermat(long p, int iterations) {
        if (p==1)
            return false; //not prime.

        for (int i=0; i<iterations; i++) {
            long random = new Random().nextInt() % (p-1) + 1;
            if (modulo(random, p-1, p) != 1)
                return false; //p is composite.
        }
        return true;
    }

    public static void main(String... args) {
        PrimalityTest primalityTest = new PrimalityTest();
        System.out.println(primalityTest.fermat(101, 10));
        System.out.println(primalityTest.rabinMiller(101, 30));
    }
}
