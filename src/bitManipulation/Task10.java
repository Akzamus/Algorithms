package bitManipulation;

// Number is sparse or not
public class Task10 {

    // Given a number N. The task is to check whether it is sparse or not.
    // A number is said to be a sparse number if no two or more consecutive
    // bits are set in the binary representation.

    public static void main(String[] args) {
        System.out.println(isSparse(41));
        System.out.println(isSparseAlternative(41));
    }

    private static boolean isSparse(int n) {
        return (n & (n >> 1)) == 0;
    }

    private static boolean isSparseAlternative(int n) {
        return !Integer.toBinaryString(n).contains("11");
    }
}
