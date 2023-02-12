package fourthTerm;

import java.util.Stack;

public class Lab1 {

    public static void main(String[] args) {
        System.out.println(countSetBits(0b1011110));
        System.out.println(findClosesPowerOfTwo(25));
        System.out.println(addBinary("10111", "1111"));
    }

    private static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            if((n & 1) != 0)
                count++;
            n >>= 1;
        }
        return count;
    }

    private static int findClosesPowerOfTwo(int n) {
        if(isPowerOfTwo(n)) return n;

        int increasingNumber = n;
        int decreasingNumber = n;

        while (true) {
            increasingNumber++;
            if(isPowerOfTwo(increasingNumber))
                return increasingNumber;

            if(decreasingNumber > 0){
                decreasingNumber--;
                if(isPowerOfTwo(decreasingNumber))
                    return decreasingNumber;
            }
        }
    }

    private static String addBinary(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(num1 + num2);
    }

    // helper method
    private static boolean isPowerOfTwo(long n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }
}
