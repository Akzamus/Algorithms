package LAB1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task5 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("12345"));
    }

    public static boolean isPalindrome(String s) {
        String str = s.chars().mapToObj(c -> (char)c)
                      .filter(Character::isLetterOrDigit)
                      .map(c -> String.valueOf(c).toLowerCase())
                      .collect(Collectors.joining());

        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }
}
