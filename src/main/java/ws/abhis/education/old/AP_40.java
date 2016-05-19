package ws.abhis.education.old;

/**
 * http://jira.abhis.ws/browse/AP-40
 */
public class AP_40 {
    public int reverseNumber(int number) {
        int rev = 0;
        while (number > 0) {
            int dig = number % 10; //find the last digit
            rev = rev * 10 + dig; //add the last digit in reverse
            number = number / 10; //truncate one digit from original
        }

        return rev;
    }

    public boolean check(int number) {
        int reverseNumber = reverseNumber(number);
        return number == reverseNumber;
    }

    public static void main(String... args) {
        AP_40 ap_40 = new AP_40();
        System.out.println(ap_40.check(151));
    }
}
