package yandex.training3.graphs.traversingGraphsInDepth.cycleSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleSearch {
    private static int n;
    private static boolean[] visited;
    private static int[] parent;
    private static boolean foundCycle;
    private static List<Integer> cycle;
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInDepth/cycleSearch/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        n = Integer.parseInt(reader.readLine().split(" ")[0]);
        visited = new boolean[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        int[][] adjMatrix = reader.lines()
                .map(s -> Arrays.stream(s.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray()
                )
                .toArray(int[][]::new);
        reader.close();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adjMatrix);
                if (foundCycle) {
                    break;
                }
            }
        }

        if (foundCycle) {
            System.out.println("YES");
            System.out.println(cycle.size() - 1);
            for (int i = 1; i < cycle.size(); i++)
                System.out.print((cycle.get(i) + 1) + " ");
        } else System.out.println("NO");
    }

    private static void dfs(int v, int p, int[][] adjMatrix) {
        visited[v] = true;
        for (int u = 0; u < n; u++) {
            if (adjMatrix[v][u] == 1) {
                if (!visited[u]) {
                    parent[u] = v;
                    dfs(u, v, adjMatrix);
                    if (foundCycle) return;
                } else if (u != p && !foundCycle) {
                    foundCycle = true;
                    cycle = new ArrayList<>();
                    cycle.add(u);
                    int curr = v;
                    while (curr != u) {
                        cycle.add(curr);
                        curr = parent[curr];
                    }
                    cycle.add(u);
                }
            }
        }
    }
}
