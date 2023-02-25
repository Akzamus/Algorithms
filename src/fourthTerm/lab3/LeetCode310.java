package fourthTerm.lab3;

import java.util.*;
import java.util.stream.IntStream;

public class LeetCode310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0 || edges.length == 0) return List.of(0);

        List<Integer> answer = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        IntStream.range(0, n).forEach(i -> graph.put(i, new HashSet<>()));

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> finalAnswer = answer;
        graph.forEach((k, v) -> {
            if (v.size() == 1) finalAnswer.add(k);
        });


        while (n > 2) {
            n -= answer.size();
            List<Integer> nextLeaves = new ArrayList<>();

            answer.forEach(leaf -> {
                int u = graph.get(leaf).iterator().next();
                graph.get(u).remove(leaf);
                if (graph.get(u).size() == 1) nextLeaves.add(u);
            });

            answer = nextLeaves;
        }

        return answer;
    }
}
