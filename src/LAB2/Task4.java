package LAB2;

import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(""));
    }

    public static boolean isPalindrome(String s) {
        long start = System.currentTimeMillis();

        String str = s.chars().mapToObj(c -> (char)c)
                .filter(Character::isLetterOrDigit)
                .map(String::valueOf)
                .collect(Collectors.joining());

        String reverseStr = new StringBuilder(str).reverse().toString();

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        return str.equalsIgnoreCase(reverseStr);
    }
}
