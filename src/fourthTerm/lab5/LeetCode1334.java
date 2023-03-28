package fourthTerm.lab5;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class LeetCode1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        int minReachableCities = n;
        int bestCity = -1;


        for (int i = 0; i < n; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            pq.offer(new int[]{i, 0});
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int u = current[0], d = current[1];
                if (d > dist[u]) continue;
                for (int[] next : graph.getOrDefault(u, new ArrayList<>())) {
                    int v = next[0], w = next[1];
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }

            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] <= distanceThreshold) {
                    reachableCities++;
                }
            }


            if (reachableCities <= minReachableCities) {
                minReachableCities = reachableCities;
                bestCity = i;
            }
        }

        return bestCity;
    }
}
