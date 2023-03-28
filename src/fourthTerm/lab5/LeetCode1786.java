package fourthTerm.lab5;

import java.util.*;

public class LeetCode1786 {

    public int countRestrictedPaths(int n, int[][] edges) {
        final int kMod = 1_000_000_007;
        List<int[]>[] graph = new List[n + 1];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] count = new int[n + 1];

        for (int i = 1; i <= n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }

        pq.offer(new int[] {n, 0});
        dist[n] = 0;
        count[n] = 1;

        while (!pq.isEmpty()) {
            int u = pq.peek()[0];
            int d = pq.poll()[1];

            if (d > dist[u])
                continue;
            for (int[] arr : graph[u]) {
                final int v = arr[0];
                final int w = arr[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new int[] {v, dist[v]});
                }
                if (dist[u] > dist[v]) {
                    count[u] += count[v];
                    count[u] %= kMod;
                }
            }
        }

        return count[1];
    }
}
