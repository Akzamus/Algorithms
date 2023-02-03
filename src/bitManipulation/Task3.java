package bitManipulation;

import java.util.stream.IntStream;

// Count total set bits
public class Task3 {

//    You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

    public static void main(String[] args) {
        System.out.println(countSetBits(200));
        System.out.println(countSetBitsAlternative(200));
    }

    private static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int m = i;
            while (m != 0) {
                if((m & 1) != 0)
                    count++;
                m >>= 1;
            }
        }
        return count;
    }

    private static int countSetBitsAlternative(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(Integer::toBinaryString)
                .mapToInt(str -> (int)str.chars().filter(ch -> ch == '1').count())
                .sum();
    }
}
