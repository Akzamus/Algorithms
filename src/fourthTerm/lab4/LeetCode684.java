package fourthTerm.lab4;

import java.util.*;

public class LeetCode684 {
    private Map<Integer, List<Integer>> graph;

    public int[] findRedundantConnection(int[][] edges) {
        graph = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> visited = new HashSet<>();
            List<Integer> temp;

            if (hasPath(edge[0], edge[1], visited))
                return edge;

            temp = graph.getOrDefault(edge[0], new ArrayList<>());
            temp.add(edge[1]);
            graph.put(edge[0], temp);

            temp = graph.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[0]);
            graph.put(edge[1], temp);
        }
        return new int[]{-1, -1};
    }

    private boolean hasPath(int u, int v, Set<Integer> visited) {
        if (u == v) return true;
        visited.add(u);
        if (!graph.containsKey(u) || !graph.containsKey(v)) return false;
        List<Integer> nexts = graph.get(u);
        for (Integer next : nexts) {
            if (visited.contains(next)) continue;
            if (hasPath(next, v, visited)) return true;
        }
        return false;
    }
}
