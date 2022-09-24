package codewars1;

public class Code7 {
    public static void main(String[] args) {
        long m = 300;
        long result = 0;
        for(long i = 0; result <= m; i++){
            result = (long)(0.25 * Math.pow(i, 2) * Math.pow(i + 1, 2));
            if(result == m) result = i;
            else if(result > m) result = -1;
        }
        System.out.println(result);
    }
}
