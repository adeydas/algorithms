package ws.abhis.education.old;

import java.util.Random;

/**
 * Created by abhishek on 4/30/15.
 * Website: adeydas.com
 */
public class ReservoirSampling {
    private int[] k;

    public void sample(int[] S, int sampleSize) {
        k = new int[sampleSize];
        if (k.length > S.length)
            return;
        if (S == null || S.length == 0)
            return;

        int i=0;
        for (i=0; i<k.length; i++)
            k[i] = S[i];

        for (int j=i; j<S.length; j++) {
            int random = getRandom(j-1);
            System.out.println("Random number " + random);
            if (random <= k.length) {
                k[random] = S[j];
            }
        }
    }

    private int getRandom(int ceil) {
        Random random = new Random();
        return Math.abs( random.nextInt() % ceil );
    }

    public int[] getK() {
        return k;
    }

    public void setK(int[] k) {
        this.k = k;
    }

    public static void main(String... args) {
        ReservoirSampling reservoirSampling = new ReservoirSampling();
        int[] S = {5,4,1,2,6,7};
        reservoirSampling.sample(S, 3);
        for (int i=0; i<reservoirSampling.getK().length; i++) {
            System.out.println(reservoirSampling.getK()[i]);
        }
    }
}
