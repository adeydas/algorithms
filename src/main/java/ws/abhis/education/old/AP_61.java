package ws.abhis.education.old;

/**
 * http://jira.abhis.ws/browse/AP-61
 */
public class AP_61 {

    public boolean checkPalindrome(String string) {
        int i=0;
        int j=string.length()-1;

        string = string.toUpperCase();

        while (i < j) {

            boolean shouldProceed = true;

            char c = string.charAt(i);

            //Check if only letters and digits. If not, increment to next character and do nothing in this iteration
            if (!((c >= 'A' && c <= 'Z') || (c>='0' && c<='9'))) {
                i++;
                shouldProceed = false;
            }

            c = string.charAt(j);

            //Check if only letters and digits. If not, increment to next character and do nothing in this iteration
            if (!((c >= 'A' && c <= 'Z') || (c>='0' && c<='9'))) {
                j--;
                shouldProceed = false;
            }



            if (shouldProceed) {
                //If letter or digit, check if it breaks palindrome property
                if (string.charAt(i) != string.charAt(j))
                    return false;

                i++;
                j--;
            }
        }

        return true;
    }

    public static void main(String... args) {
        AP_61 ap_61 = new AP_61();
        System.out.println(ap_61.checkPalindrome("A!#A"));
        System.out.println(ap_61.checkPalindrome("A!#B"));
        System.out.println(ap_61.checkPalindrome("A man, a plan, a canal, Panama!"));
        System.out.println(ap_61.checkPalindrome("ABA"));
    }
}
