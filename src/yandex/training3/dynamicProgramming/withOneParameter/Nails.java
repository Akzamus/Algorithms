package yandex.training3.dynamicProgramming.withOneParameter;

import java.util.Arrays;
import java.util.Scanner;

public class Nails {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        int[] coordinates = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            coordinates[i] = in.nextInt();
        }
        in.close();
        Arrays.sort(coordinates);

        dp[1] = 0;
        dp[2] = coordinates[2] - coordinates[1];

        if(N > 2) {
            dp[3] = coordinates[3] - coordinates[1];
            for (int i = 4; i < N + 1; i++) {
                dp[i] = Math.min(dp[i - 2], dp[i - 1])
                        + coordinates[i]
                        - coordinates[i - 1];
            }
        }

        System.out.println(dp[N]);
    }
}
