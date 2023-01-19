package codewars1;

import java.util.*;

public class Code12 {

    public static void main(String[] args) {
        String text = """
                      Slavery was abolished in all states north of the Mason–Dixon 
                      line by 1804, but states in the south continued the institution, 
                      to support the kinds of large scale agriculture that dominated the 
                      southern economy.
                      """;

        System.out.println(reverse(text));
    }

    private static String reverse(String str) {
        String[] wordsArray = str.replaceAll("[^A-Za-z]", " ").split("[\\s]+");
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> wordsSet = new HashSet<>(Arrays.asList(wordsArray));

        for (String word : wordsSet) {
            stringBuilder.setLength(0);
            stringBuilder.append(word);
            str = str.replaceAll(word, stringBuilder.reverse().toString());
        }

        return str;
    }
}
