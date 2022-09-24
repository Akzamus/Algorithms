package LAB1;

public class Task4 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }

    public static int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        long start = 1, end = x / 2, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid * mid == x)
                return (int)mid;

            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return (int)ans;
    }
}
