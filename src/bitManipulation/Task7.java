package bitManipulation;

// Swap all odd and even bits
public class Task7 {

    // Given an unsigned integer N.
    // The task is to swap all odd bits with even bits.
    // For example, if the given number is 23 (00010111), it should be converted to 43(00101011).
    // Here, every even position bit is swapped with an adjacent bit on the right side(even position
    // bits are highlighted in the binary representation of 23), and every odd position bit is swapped
    // with an adjacent on the left side.

    // 00010111
    // 0 0 0 1  =>  0 0 0 1
    //  0 1 1 1 => 0 1 1 1 1
    //             00101011

    public static void main(String[] args) {
        System.out.println(swapBits(23));
    }

    private static int swapBits(int n) {
        int evenBits = n & 0xAAAAAAAA;
        int oddBits = n & 0x55555555;
        evenBits >>= 1;
        oddBits <<= 1;
        return evenBits | oddBits;
    }
}
