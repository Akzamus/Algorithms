package yandex.training3.graphs.traversingGraphsInWidth.fleas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Fleas {
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInWidth/fleas/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String[] values = reader.readLine().split(" ");

        final int N = Integer.parseInt(values[0]);
        final int M = Integer.parseInt(values[1]);

        final int S = Integer.parseInt(values[2]) - 1;
        final int T = Integer.parseInt(values[3]) - 1;

        final int Q = Integer.parseInt(values[4]);

        boolean[][] visited = new boolean[N][M];
        visited[S][T] = true;

        int[][] dist = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, T});

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currDist = dist[currX][currY];

            for (int i = 0; i < 8; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    dist[nextX][nextY] = currDist + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        int totalDist = 0;

        for (int i = 0; i < Q; i++) {
            String[] coordinates = reader.readLine().split(" ");
            int x = Integer.parseInt(coordinates[0]) - 1;
            int y = Integer.parseInt(coordinates[1]) - 1;

            if(visited[x][y]) {
                totalDist += dist[x][y];
            } else {
                System.out.println(-1);
                reader.close();
                System.exit(0);
            }
        }

        reader.close();
        System.out.println(totalDist);
    }
}
