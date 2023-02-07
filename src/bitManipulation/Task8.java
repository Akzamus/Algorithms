package bitManipulation;

import java.util.Arrays;

// Longest Consecutive 1's
public class Task8 {

    // Given a number N. Find the length of the longest consecutive 1s in its binary representation.

    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(222));
        System.out.println(maxConsecutiveOnesAlternative(222));
    }

    private static int maxConsecutiveOnes(int n) {
        int count = 0;
        int maxCount = 0;

        for (; n != 0; n >>= 1) {
            if((n & 1) == 0) {
                if(count > maxCount) maxCount = count;
                count = 0;
            } else { count++; }
        }

        if(count > maxCount) maxCount = count;
        return maxCount;
    }

    private static int maxConsecutiveOnesAlternative(int n) {
        return Arrays.stream(Integer.toBinaryString(n).split("[0]+"))
                     .mapToInt(String::length)
                     .max()
                     .getAsInt();
    }
}
