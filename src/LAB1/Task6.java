package LAB1;

import java.util.Arrays;

public class Task6 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bs bsd abcde"));
    }

    public static int lengthOfLongestSubstring(String str) {
        int result = 0;
        int [] lastIndexOfOccurrence = new int[256];

        Arrays.fill(lastIndexOfOccurrence, -1);

        int i = 0;

        for (int j = 0; j < str.length(); j++) {
            i = Math.max(i, lastIndexOfOccurrence[str.charAt(j)] + 1);
            result = Math.max(result, j - i + 1);
            lastIndexOfOccurrence[str.charAt(j)] = j;
        }

        return result;
    }
}
