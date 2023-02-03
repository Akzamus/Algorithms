package bitManipulation;

//Rightmost different bit
public class Task5 {

//    Given two numbers M and N. The task is to find the position of the rightmost
//    different bit in the binary representation of numbers.

    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(7, 15));
    }

    private static int posOfRightMostDiffBit(int m, int n) {
        int position = 1;
        while (m != 0 || n != 0) {
            if((m & 1) != (n & 1))
                return position;
            position++;
            m >>= 1;
            n >>= 1;
        }
        return -1;
    }
}
