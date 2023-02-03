package bitManipulation;

// Find first set bit
public class Task2 {

//    Given an integer N.
//    The task is to return the position of first set bit found from the right side in the binary representation of the number.
//    Note: If there is no set a bit in the integer N, then return 0 from the function.

    public static void main(String[] args) {
        System.out.println(getFirstSetBit(33));
        System.out.println(getFirstSetBitAlternative(33));
    }

    private static int getFirstSetBit(int n) {
        if (n == 0) return 0;
        int position = 1,
            m = 1;

        while ((n & m) == 0) {
            m <<= 1;
            position++;
        }

        return position;
    }

    private static int getFirstSetBitAlternative(int n) {
        String binaryRepresentationN = Integer.toBinaryString(n);
        int length = binaryRepresentationN.length();

        for (int i = length - 1; i >= 0; i--)
            if(binaryRepresentationN.charAt(i) == '1')
                return length - i;
        return 0;
    }
}
