package ws.abhis.education.old;

/**
 * http://abhis.ws/display/AL/Edit+Distance
 */
public class EditDistance {

    public int findEditDistance(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] lev = new int[length1+1][length2+1];

        //initialize lev[i][0]=i
        for (int i=0; i<=length1; i++) {
            lev[i][0] = i;
        }

        //initialize lev[0][j]=j
        for (int j=0; j<=length2; j++) {
            lev[0][j] = j;
        }

        for (int i=0; i<length1; i++) {
            char c1 = str1.charAt(i);
            for (int j=0; j<length2; j++) {
                char c2 = str2.charAt(j);

                if (c1 == c2) {
                    //if chars are equal, no increase in cost
                    lev[i+1][j+1] = lev[i][j];
                } else {
                    //find individual cost for insert, delete and replace
                    int insert = lev[i][j+1]+1;
                    int delete = lev[i+1][j]+1;
                    int replace = lev[i][j]+1; //this can be two based on the cost definition

                    //find min of the three costs and insert in matrix
                    int min = min(insert, replace, delete);
                    lev[i+1][j+1] = min;
                }
            }
        }

        return lev[length1][length2];
    }

    private int min(int insert, int replace, int delete) {
        int min = Math.min(insert, replace);
        return Math.min(delete, min);
    }

    public static void main(String... args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.findEditDistance("kitten", "sitting")); //example from Wikipedia
    }

}
