package yandex.training3.graphs.traversingGraphsInWidth.shortestPathLength;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathLength {
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInWidth/shortestPathLength/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        final int N = Integer.parseInt(reader.readLine().split(" ")[0]);

        int[][] adjMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            adjMatrix[i] = Arrays.stream(reader.readLine().split(" "))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
        }

        String[] vertexes = reader.readLine().split(" ");
        int start = Integer.parseInt(vertexes[0]) - 1;
        int end = Integer.parseInt(vertexes[1]) - 1;
        reader.close();

        boolean[] visited = new boolean[N];
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int vertex = current[0];
            int level = current[1];
            if (vertex == end) {
                System.out.println(level);
                System.exit(0);
            }
            for (int i = 0; i < N; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new int[] {i, level + 1});
                }
            }
        }

        System.out.println("-1");
    }
}
