package yandex.training3.graphs.traversingGraphsInDepth.searchInDepth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SearchInDepth {

    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInDepth/searchInDepth/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] vAndE = Arrays.stream(reader.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        reader.lines()
              .map(s -> s.split(" "))
              .forEach(arr -> bind(arr, graph));
        reader.close();

        boolean[] visited = new boolean[vAndE[0] + 1];
        Queue<Integer> fCompOfConComp = new PriorityQueue<>();

        for (int vertex : graph.keySet()) {
            if(!visited[vertex]) {
                fCompOfConComp.clear();
                dfs(graph, visited, vertex, fCompOfConComp);
                System.out.println(fCompOfConComp.size());
                while (!fCompOfConComp.isEmpty())
                    System.out.print(fCompOfConComp.poll() + " ");
            }
        }

    }

    private static void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int now, Queue<Integer> fCompOfConComp) {
        visited[now] = true;
        fCompOfConComp.add(now);

        for (int neighbor : graph.get(now)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor, fCompOfConComp);
            }
        }

    }

    private static void bind(String arr[], Map<Integer, List<Integer>> graph) {
        int v1 = Integer.parseInt(arr[0]);
        int v2 = Integer.parseInt(arr[1]);

        graph.putIfAbsent(v1, new ArrayList<>());
        graph.putIfAbsent(v2, new ArrayList<>());

        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }
}
