package ws.abhis.education.old;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhishek on 4/30/15.
 * Website: adeydas.com
 */
public class Sieve {

    public class Element {
        private int ele;
        private boolean marked;

        public boolean isMarked() {
            return marked;
        }

        public void setMarked(boolean marked) {
            this.marked = marked;
        }

        public int getEle() {
            return ele;
        }

        public void setEle(int ele) {
            this.ele = ele;
        }

        public Element(int ele, boolean marked) {
            this.ele = ele;
            this.marked = marked;
        }
    }

    public List<Integer> segmentSoe(int start, int end) {
        //Initialize array.
        List<Element> allNumbers = new LinkedList<Element>();
        //Populate with all numbers from start to end.
        for (int i=start; i<=end; i++)
            allNumbers.add(new Element(i, false));

        int N = (int) Math.sqrt(end);
        List<Integer> initialPrimes = soe(N);



        for (int i=0; i<initialPrimes.size(); i++) {
            int p = initialPrimes.get(i);
            int x = (int) Math.floor(start/p);
            x = x*p;
            if (x<start)
                x=x+p;


            while (x <= end) {

                for (int z=0; z<allNumbers.size(); z++) {
                    if (allNumbers.get(z).getEle() == x) {
                        Element ele = allNumbers.get(z);
                        ele.setMarked(true);
                        allNumbers.set(z, ele);
                        x=x+p;
                    }
                }
            }
        }

        List<Integer> retList = new LinkedList<Integer>();
        for (int s=0; s<allNumbers.size(); s++) {
            if (!allNumbers.get(s).isMarked())
                retList.add(allNumbers.get(s).getEle());
        }

        return retList;
    }

    public List<Integer> soe(int S) { //S=population size.
        //Initialize array.
        List<Element> allNumbers = new LinkedList<Element>();
        //Populate with all numbers from 2 to S (inclusive).
        int i = 1;
        while (++i <= S) {
            allNumbers.add(new Element(i, false));
        }

        //Initialize p to the first prime number.
        int p=2;
        //Initialize m to first multiple second to 1.
        int m=2;
        int n=0; //Index of p.

        //Loop and mark.
        while (p <= Math.sqrt(S)) {
            while (m * p <= S) {
                Element e = allNumbers.get(m * p - 2); //2 subtracted to match with modified index numbers.
                e.setMarked(true);
                allNumbers.set(m * p - 2, e);
                m++;
            }
            while (allNumbers.get(++n).isMarked());
            p = allNumbers.get(n).getEle();
            m=2;
        }

        //Return non-marked numbers.
        List<Integer> returnList = new LinkedList<Integer>();
        for (int f=0; f<allNumbers.size(); f++) {
            if (!allNumbers.get(f).isMarked()) {
                returnList.add(allNumbers.get(f).getEle());
            }
        }

        return returnList;

    }

    public static void main(String... args) {
        Sieve sieve = new Sieve();
        long startTime = System.currentTimeMillis();
        List<Integer> retList = sieve.soe(500);
        long endTime = System.currentTimeMillis();
        long diff = endTime-startTime;
        System.out.println("\nTime diff for SOE = " + diff + " with size " + retList.size());

        startTime = System.currentTimeMillis();
        retList = sieve.segmentSoe(100, 500);
        endTime = System.currentTimeMillis();
        diff = endTime-startTime;
        System.out.println("\nTime diff for segmented SOE = " + diff + " with size " + retList.size());


    }


}
