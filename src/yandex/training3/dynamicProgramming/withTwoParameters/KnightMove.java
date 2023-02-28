package yandex.training3.dynamicProgramming.withTwoParameters;

import java.util.Scanner;

public class KnightMove {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int M = in.nextInt();

        int[][] dp = new int[N + 1][M + 1];

        dp[1][1] = 1;
        for (int i = 2; i < N + 1; i++)
            for (int j = 2; j < M + 1; j++)
                dp[i][j] = dp[i - 1][j - 2] + dp[i - 2][j - 1];

        System.out.println(dp[N][M]);
        in.close();
    }
}