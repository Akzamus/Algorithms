package yandex.training3.dynamicProgramming.withTwoParameters.theCheapestWay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TheCheapestWay {

    private static final String inputPath = "src/yandex/training3/dynamicProgramming/withTwoParameters/theCheapestWay/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        final int[][] table = reader.lines()
                                    .skip(1)
                                    .map(s -> Arrays.stream(s.split(" "))
                                                    .mapToInt(Integer::parseInt)
                                                    .toArray()
                                    )
                                    .toArray(int[][]::new);

        reader.close();

        final int N = table.length;
        final int M = table[0].length;

        int[][] dp = new int[N + 1][M + 1];

        Arrays.fill(dp[0], Integer.MAX_VALUE);

        for (int i = 1; i < N + 1; i++)
            dp[i][0] = Integer.MAX_VALUE;

        dp[0][1] = 0;
        dp[1][0] = 0;

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + table[i - 1][j - 1];

        System.out.println(dp[N][M]);
    }
}
