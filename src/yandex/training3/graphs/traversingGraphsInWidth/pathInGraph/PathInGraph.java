package yandex.training3.graphs.traversingGraphsInWidth.pathInGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PathInGraph {
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInWidth/pathInGraph/input.txt";

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

        if(start == end) {
            System.out.println(0);
            System.exit(0);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visited = new boolean[N];
        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int vertex = current[0];

            if (visited[vertex]) continue;
            if (vertex == end) break;

            visited[vertex] = true;

            for (int i = 0; i < N; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    int newDist = dist[vertex] + 1;
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        prev[i] = vertex;
                        queue.offer(new int[]{i, newDist});
                    }
                }
            }
        }

        if (prev[end] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(dist[end]);
            List<Integer> path = new ArrayList<>();
            int vertex = end;
            while (vertex != -1) {
                path.add(vertex + 1);
                vertex = prev[vertex];
            }
            Collections.reverse(path);
            System.out.println(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
