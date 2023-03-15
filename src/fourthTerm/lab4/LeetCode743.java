package fourthTerm.lab4;

import java.util.*;

public class LeetCode743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        for (int node : adjList.keySet()) {
            Collections.sort(adjList.get(node), Comparator.comparingInt(a -> a[1]));
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dfs(adjList, dist, k, 0);

        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dist.get(i) == Integer.MAX_VALUE) return -1;
            ret = Math.max(ret, dist.get(i));
        }

        return ret;
    }

    private void dfs(Map<Integer, List<int[]>> adjList, Map<Integer, Integer> dist, int start, int elapsed) {
        if (elapsed >= dist.get(start)) return;
        dist.put(start, elapsed);
        if (adjList.containsKey(start)) {
            for (int[] next : adjList.get(start)) {
                dfs(adjList, dist, next[0], elapsed + next[1]);
            }
        }
    }
}
