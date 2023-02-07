package bitManipulation;

// A bit of Difference
public class Task6 {

    // You are given two numbers A and B.
    // The task is to count the number of bits needed to be flipped to convert A to B.

    public static void main(String[] args) {
        System.out.println(countBitsFlip(10, 20));
        System.out.println(countBitsFlipAlternative(10, 20));
    }

    private static int countBitsFlip(int a, int b) {
        int m = a ^ b;
        int count = 0;

        while (m != 0) {
            if((m & 1) != 0)
                count++;
            m >>= 1;
        }
        return count;
    }

    private static int countBitsFlipAlternative(int a, int b) {
        return (int) Integer.toBinaryString(a ^ b)
                            .chars()
                            .filter(ch -> ch == '1')
                            .count();
    }
}
