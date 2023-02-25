package fourthTerm.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode438 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String str, String p) {
        List<Integer> indexes = new ArrayList<>();
        int anagramLen = p.length();
        int numOfIteration = str.length() - p.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i <= numOfIteration; i++) {
            String subStr;
            if(numOfIteration == i) subStr = str.substring(i);
            else subStr = str.substring(i, i + anagramLen);

            char[] subChars = subStr.toCharArray();
            Arrays.sort(subChars);
            if(Arrays.equals(subChars, chars)) indexes.add(i);
        }
        return indexes;
    }
}
