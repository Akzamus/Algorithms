package yandex.training3.graphs.traversingGraphsInDepth.connectivityComponents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectivityComponents {

    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInDepth/connectivityComponents/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        final int N = Integer.parseInt(reader.readLine().split(" ")[0]) + 1;

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        reader.lines()
              .map(s -> s.split(" "))
              .forEach(arr -> {
                  int v1 = Integer.parseInt(arr[0]);
                  int v2 = Integer.parseInt(arr[1]);
                  graph.get(v1).add(v2);
                  graph.get(v2).add(v1);
              });
        reader.close();

        visited = new boolean[N];

        List<List<Integer>> components = IntStream.range(1, N)
                                                  .filter(i -> !visited[i])
                                                  .mapToObj(i -> dfs(i, new ArrayList<>()))
                                                  .collect(Collectors.toList());

        System.out.println(components.size());
        components.forEach(c -> {
            System.out.println(c.size());
            c.forEach(v -> System.out.print(v + " "));
            System.out.println();
        });
    }

    private static List<Integer> dfs(int vertex, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        graph.get(vertex).stream()
                         .filter(n -> !visited[n])
                         .forEach(n -> dfs(n, component));
        return component;
    }
}
