package yandexTraining3;

import java.util.*;

public class BeautifulString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String input = in.nextLine();
        printBeautifulString(input, k);
    }

    private static void printBeautifulString(String input, int k) {
        char[] chars = input.toCharArray();
        int left = 0,
            right = 0,
            n = chars.length;

        Map<Character, Integer> hm = new HashMap<>();
        int maxLen = 0,
            mostFreq = 0;

        while (right < n) {
            hm.put(chars[right], hm.getOrDefault(chars[right], 0) + 1);
            mostFreq = Math.max(mostFreq, hm.get(chars[right]));

            if((right - left + 1) - mostFreq > k){
                hm.put(chars[left], hm.get(chars[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        System.out.println(maxLen);
    }
}
