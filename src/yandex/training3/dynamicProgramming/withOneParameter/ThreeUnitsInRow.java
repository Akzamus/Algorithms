package yandex.training3.dynamicProgramming.withOneParameter;

import java.util.Scanner;

public class ThreeUnitsInRow {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(
                printNumberOfSequences(in.nextInt())
        );
        in.close();
    }

    private static int printNumberOfSequences(final int N) {
        int[] dp = new int[N];

        if(N > 3) {
            dp[0] = 2; dp[1] = 4; dp[2] = 7;

            for (int i = 3; i < N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return switch (N) {
            case 1 -> 2;
            case 2 -> 4;
            case 3 -> 7;
            default -> dp[N - 1];
        };
    }
}
