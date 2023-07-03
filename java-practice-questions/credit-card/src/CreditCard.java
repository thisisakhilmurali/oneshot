import java.util.*;

public class CreditCard {
    public static boolean buggyIsValidCreditCard(String cardNumber) {

        if (cardNumber.length() != 16) {
            return false;
        }

        char startDigit = cardNumber.charAt(0);
        if (startDigit != '4' && startDigit != '5' && startDigit != '6') {
            return false;
        }

        for (char c : cardNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // Luhn algorithm
        int sum = 0;
        boolean doubleDigit = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = cardNumber.charAt(i) - '0';

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit % 10 + 1;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        boolean result = buggyIsValidCreditCard(str);

        System.out.println(result? "1": "0");
    }
}