package bitManipulation;

// Power of 2
public class Task4 {

//    Given a non-negative integer N.
//    The task is to check if N is a power of 2.
//    More formally, check if N can be expressed as 2x for some x.

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwoAlternative(128));
    }

    private static boolean isPowerOfTwo(long n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }

    private static boolean isPowerOfTwoAlternative(long n) {
        if (n == 1)                    return true;
        else if (n % 2 != 0 || n == 0) return false;
        else                           return isPowerOfTwo(n / 2);
    }
}
