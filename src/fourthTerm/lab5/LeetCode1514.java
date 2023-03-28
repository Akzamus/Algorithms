package fourthTerm.lab5;

import java.util.*;

public class LeetCode1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            adj[a].add(new double[] {b, p});
            adj[b].add(new double[] {a, p});
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[] {start, 1.0});

        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            double[] node = pq.poll();
            int curr = (int) node[0];
            double prob = node[1];

            if (curr == end) {
                return prob;
            }

            if (!visited.contains(curr)) {
                visited.add(curr);
                for (double[] neighbor : adj[curr]) {
                    int next = (int) neighbor[0];
                    double neighborSuccProb = neighbor[1];
                    if (!visited.contains(next)) {
                        pq.offer(new double[] {next, prob * neighborSuccProb});
                    }
                }
            }
        }

        return 0.0;
    }
}
