package fourthTerm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lab6 {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 11, 12, 0, 0, 0},
                {0, 0, 0, 12, 0, 0},
                {0, 1, 0, 0, 11, 0},
                {0, 0, 0, 0, 0, 19},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        System.out.println(FordFulkerson.findMaxFlow(graph, 0, 5));
    }
}

class FordFulkerson {

    public static int findMaxFlow(int[][] graph, int source, int destination) {
        int[] parent = new int[graph.length];
        int maxFlow = 0;

        while (bfs(graph, source, destination, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            for (int v = destination; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, graph[u][v]);
            }

            for (int v = destination; v != source; v = parent[v]) {
                int u = parent[v];
                graph[u][v] -= pathFlow;
                graph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private static boolean bfs(int[][] newGraph, int source, int destination, int[] parent) {
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[newGraph.length];
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < newGraph.length; v++) {
                if (!visited[v] && newGraph[u][v] > 0) {
                    parent[v] = u;
                    visited[v] = true;
                    queue.add(v);
                    if (v == destination) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}