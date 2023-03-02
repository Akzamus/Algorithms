package yandex.training3.graphs.traversingGraphsInDepth.topologicalSorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {

    private static List<List<Integer>> graph;
    private static Stack<Integer> stack = new Stack<>();
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInDepth/topologicalSorting/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        final int N = Integer.parseInt(reader.readLine().split(" ")[0]) + 1;

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        reader.lines()
                .map(s -> s.split(" "))
                .forEach(arr -> {
                    graph.get(Integer.parseInt(arr[0]))
                         .add(Integer.parseInt(arr[1]));
                });
        reader.close();

        int[] colors = new int[N];
        for (int i = 1; i < N; i++)
            if(colors[i] == 0) dfs(i, colors);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private static void dfs(int vertex, int[] colors) {
        colors[vertex] = 1;
        for (int neighbor : graph.get(vertex)) {
            if(colors[neighbor] == 0) dfs(neighbor, colors);
            if(colors[neighbor] == 1) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        stack.add(vertex);
        colors[vertex] = 2;
    }
}
