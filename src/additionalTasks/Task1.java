package additionalTasks;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(convert("29234652", 10, 36));
    }

    public static String convert(String originalNumber, int fromRadix, int toRadix) {
        List<Character> digits = getDigitTable();
        StringBuilder result = new StringBuilder();
        originalNumber = new StringBuilder(originalNumber).reverse().toString();
        int decimalNumber = 0;

        for (int i = 0; i < originalNumber.length(); i++)
            decimalNumber +=  digits.indexOf(originalNumber.charAt(i)) * Math.pow(fromRadix, i);

        for (; decimalNumber > 0; decimalNumber /= toRadix)
            result.insert(0, digits.get(decimalNumber % toRadix));

        return result.toString();
    }

    private static List<Character> getDigitTable() {
        ArrayList<Character> digits = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++)
            digits.add(i);
        for (char i = 'A'; i <= 'Z'; i++)
            digits.add(i);
        return digits;
    }
}
