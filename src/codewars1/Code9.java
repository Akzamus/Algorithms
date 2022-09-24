package codewars1;

import java.util.Arrays;
import java.util.Comparator;

public class Code9 {
    public static void main(String[] args) {
        String[] a1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] a2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        Arrays.sort(a1, (o1, o2) -> {
            if(o1.length() > o2.length()) return 1;
            else if(o1.length() < o2.length()) return -1;
            else return -1;
        });
        Arrays.sort(a2, (o1, o2) -> {
            if(o1.length() > o2.length()) return 1;
            else return -1;
        });
        System.out.println(Math.max(Math.abs(a1[a1.length - 1].length() - a2[0].length()),
                           Math.abs(a2[a2.length - 1].length() - a1[0].length())));
    }
}
