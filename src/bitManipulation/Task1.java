package bitManipulation;

// Check whether K-th bit is set or not
public class Task1 {

//    Given a number N and a bit number K, check if Kth bit of N is set or not.
//    A bit is called set if it is 1.
//    Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.

    public static void main(String[] args) {
        System.out.println(kThBitIsExists(39, 5));
        System.out.println(kThBitIsExistsAlternative(39, 5));
    }

    private static boolean kThBitIsExists(int n, int k) {
        return ((n >> k) & 1) != 0;
    }

    private static boolean kThBitIsExistsAlternative(int n, int k) {
        String binaryRepresentationN = Integer.toBinaryString(n);
        int length = binaryRepresentationN.length();
        if(k + 1 > length || k < 0) return false;
        return binaryRepresentationN.charAt(length - k - 1) == '1';
    }
}