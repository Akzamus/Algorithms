package LAB1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task9 {

    public static void main(String[] args) {
        System.out.println(intToRoman(19));
    }

    public static String intToRoman(int number) {
        Map<String, Integer> romanNumbersMap = new LinkedHashMap<>();

        romanNumbersMap.put("M", 1000);
        romanNumbersMap.put("CM", 900);
        romanNumbersMap.put("D", 500);
        romanNumbersMap.put("CD", 400);
        romanNumbersMap.put("C", 100);
        romanNumbersMap.put("XC", 90);
        romanNumbersMap.put("L", 50);
        romanNumbersMap.put("XL", 40);
        romanNumbersMap.put("X", 10);
        romanNumbersMap.put("IX", 9);
        romanNumbersMap.put("V", 5);
        romanNumbersMap.put("IV", 4);
        romanNumbersMap.put("I", 1);

        String result = "";

        for(Map.Entry<String, Integer> entry : romanNumbersMap.entrySet()) {
            int matches = number / entry.getValue();
            result = result + repeatNumbers(entry.getKey(), matches);
            number = number % entry.getValue();
        }
        return result;
    }

    public static String repeatNumbers(String romanNum, int n) {
        String result = "";
        for(int i = 0; i < n; i++)
            result += romanNum;
        return result;
    }
}
