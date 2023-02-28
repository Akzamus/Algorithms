package yandex.training3.dynamicProgramming.withTwoParameters.printRouteOfMaximumCost;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PrintRouteOfMaximumCost {

    private static final String inputPath = "src/yandex/training3/dynamicProgramming/withTwoParameters/printRouteOfMaximumCost/input.txt";

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

        dp[0][1] = 0;
        dp[1][0] = 0;

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + table[i - 1][j - 1];

        List<String> result = new LinkedList<>();
        int i = N;
        int j = M;

        while (true) {
            if(i == 1 && j == 1) break;

            if(j != 1 && dp[i][j - 1] > dp[i - 1][j]) {
                j--;
                result.add("R");
            } else {
                i--;
                result.add("D");
            }
        }

        Collections.reverse(result); 
        System.out.println(dp[N][M]);
        System.out.println(result.stream().collect(Collectors.joining(" ")));
    }
}