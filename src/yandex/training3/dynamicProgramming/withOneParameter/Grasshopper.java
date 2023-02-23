package yandex.training3.dynamicProgramming.withOneParameter;

import java.util.Scanner;

public class Grasshopper {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int K = in.nextInt();
        in.close();

        int[] dp = new int[N + K];

        for (int i = 0; i < K; i++) {
            dp[i] = 0;
        }

        dp[K] = 1;

        for (int i = K + 1; i < dp.length; i++) {
            for (int j = i - 1; j >= i - K; j--) {
                dp[i] += dp[j];
            }
        }

        System.out.println(dp[dp.length - 1]);
    }
}
