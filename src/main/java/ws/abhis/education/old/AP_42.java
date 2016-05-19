package ws.abhis.education.old;

/**
 * http://jira.abhis.ws/browse/AP-42
 */
public class AP_42 {

    //O(n2) implementation
    public String findLargestPalindrome(String string) {
        if (string.length() > 2) {
            char[] carr = string.toCharArray();

            int maxPalindromeLength = Integer.MIN_VALUE;
            int globalBegin = 0;
            int globalEnd = 0;

            for (int i=3; i<carr.length; i++) {
                int mid = i;
                int begin = i-1;
                int end = i+1;
                while (begin >= 0 && end <= carr.length-1) {
                    if (carr[begin] != carr[end])
                        break;
                    begin--;
                    end++;
                }
                int palindromeLength = (end-begin)+1;
                if (palindromeLength > maxPalindromeLength) {
                    maxPalindromeLength = palindromeLength;
                    globalBegin = begin+1;
                    globalEnd = end-1;
                }
            }

            String result = "";

            for (int i=globalBegin; i<=globalEnd; i++) {
                result += Character.toString(carr[i]);
            }

            return result;
        } else {
            return string;
        }
    }


    /*
    Start code using Manacher's algorithm
     */

    /**
     * Add '*' to input string
     * @param string
     * @return
     */
    public String preprocess(String string) {
        StringBuffer append = new StringBuffer();
        append.append("*");
        for (int i=0 ; i < string.length() ; i++) {
            append.append(string.charAt(i));
            append.append("*");
        }
        return append.toString();
    }

    public String longestPalindrome(String string) {
        String s = preprocess(string);
        char[] T = s.toCharArray();
        int n = T.length;
        int[] LPS = new int[n];
        int centerPos = 0, centerRightPos = 0;

        for (int i=1; i<n-1; i++) {
            int i_mirror = 2*centerPos-i;

            LPS[i] = (centerRightPos > i) ? Math.min(centerRightPos - i, LPS[i_mirror]) : 0;

            while(T[i + 1 + LPS[i]] == T[i - 1 - LPS[i]])
                LPS[i]++;

            if (i + LPS[i] > centerRightPos) {
                centerPos = i;
                centerRightPos = i + LPS[i];
            }
        }

        int maxlen = 0;
        int centerIndex = 0;
        for (int i=1; i<n-1; i++) {
            if (LPS[i] > maxlen) {
                maxlen = LPS[i];
                centerIndex = i;
            }
        }

        return string.substring((centerIndex - 1 - maxlen)/2, maxlen);
    }
    /*
    End code using Manacher's algorithm
     */



    public static void main(String... args) {
        String str = "RACECAR";

        AP_42 ap_42 = new AP_42();
        System.out.println(ap_42.findLargestPalindrome(str));

        String preprocess = ap_42.longestPalindrome(str);
        System.out.println("Manacher's : " + preprocess);
    }

}
