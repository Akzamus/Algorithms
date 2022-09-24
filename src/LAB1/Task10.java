package LAB1;

public class Task10 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse (int num) {

        int reverseNum = 0;
        boolean isNegative = false;

        if(num < 0) {
            num = -num;
            isNegative = true;
        }

        while(num > 0) {
            int reminder = num % 10 ;

            if(reverseNum > Integer.MAX_VALUE/10 || reverseNum == Integer.MAX_VALUE/10 && reminder > 7 ||
               reverseNum < Integer.MIN_VALUE/10 || reverseNum == Integer.MIN_VALUE/10 && reminder < -8) {
                return 0 ;
            }

            num /= 10 ;
            reverseNum = reverseNum * 10 + reminder;
        }

        return isNegative ? -reverseNum : reverseNum;
    }
}
