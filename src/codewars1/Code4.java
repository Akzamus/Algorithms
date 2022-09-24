package codewars1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Code4 {
    public static void main(String[] args) {
        String str = "Success";
        String f = Arrays.stream(str.split("")).map(s -> {
            int count = str.length() - str.replace(s.toLowerCase(),"").replace(s.toUpperCase(), "").length();
            if (count > 1) return  ")";
            else return  "(";
        }).collect(Collectors.joining());
        System.out.println(f);
    }
}
