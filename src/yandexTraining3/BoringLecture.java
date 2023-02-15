package yandexTraining3;

import java.util.*;

public class BoringLecture {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        printCharAndNumInWordsThatCanBeMadeOfThisWord(input);
    }

    private static void printCharAndNumInWordsThatCanBeMadeOfThisWord(String input) {
        Map<Character, Long> map = new TreeMap<>();
        long len = input.length();
        long i = 0;

        for (char ch : input.toCharArray()) {
            map.merge(ch, (len - i) * (i + 1), Long::sum);
            i++;
        }
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}