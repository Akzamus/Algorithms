package yandex.training3.graphs.traversingGraphsInDepth.cheating;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cheating {

    private static boolean graph[][] = new boolean[110][110];
    private static int[] visited = new int[110];
    private static boolean canSplit = true;
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInDepth/cheating/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        final int N = Integer.parseInt(reader.readLine().split(" ")[0]);

        reader.lines()
                .map(s -> s.split(" "))
                .forEach(arr -> {
                    int v1 = Integer.parseInt(arr[0]);
                    int v2 = Integer.parseInt(arr[1]);
                    graph[v1][v2] = true;
                    graph[v2][v1] = true;
                });
        reader.close();

        for (int i = 1; i <= N; i++) {
            if(visited[i] == 0) dfs(i, 1, N);
        }

        System.out.println(canSplit ? "YES" : "NO");
    }

    private static void dfs(int vertex, int color, int N) {
        if(!canSplit) return;
        visited[vertex] = color;

        for (int i = 1; i <= N; i++) {
            if(graph[vertex][i]) {
                if(visited[i] == 0) dfs(i, 3 - color, N);
                if(visited[i] == visited[vertex]) canSplit = false;
            }
        }
    }
}

