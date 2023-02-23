package yandex.training3.dynamicProgramming.withOneParameter.buyingTickets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BuyingTickets {

    private static final String inputPath = "src/yandex/training3/dynamicProgramming/withOneParameter/buyingTickets/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        final int N = Integer.parseInt(reader.readLine());
        int[][] time = new int[N + 3][3];
        int[] dp = new int[N + 3];

        for (int i = 0; i < 3; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        for (int i = N + 2; i >= 3; i--) {
            time[i] = Arrays.stream(reader.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
        reader.close();

        for (int i = 3; i < N + 3; i++) {
            dp[i] = Math.min(
                        Math.min(
                            dp[i - 1] + time[i][0],
                            dp[i - 2] + time[i][1]
                        ),  dp[i - 3] + time[i][2]
            );
        }

        System.out.println(dp[N + 2]);
    }
}
