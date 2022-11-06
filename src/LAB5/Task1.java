package LAB5;

import java.util.Arrays;

public class Task1 {
    public int[] findBall(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;

        // status of i-th column
        int[] status = new int[N];
        int[] answers = new int[N];
        Arrays.fill(answers, -1);

        for (int i = 0; i < N; ++i)
            status[i] = i;

        for (int i = 0; i < M; i++) {
            int[] newStatus = new int[N];
            Arrays.fill(newStatus, -1);

            for (int j = 0; j < N; j++) {

                //Out of bound || Stuck
                if ((j + grid[i][j] < 0 || j + grid[i][j] == N) ||
                    (grid[i][j] == 1 && grid[i][j + 1] == -1 || grid[i][j] == -1 && grid[i][j - 1] == 1)
                ) continue;

                newStatus[j + grid[i][j]] = status[j];
            }

            status = newStatus;
        }

        for (int i = 0; i < N; i++)
            if (status[i] != -1)
                answers[status[i]] = i;

        return answers;
    }
}
