package fourthTerm.lab4;

import java.util.*;

public class MinCostToConnectAllPoints {

    private static Map<Integer, Integer> parent = new HashMap<>();

    private record Edge (int src, int dest, int weight) { }

    public static void main(String[] args) {
        int[][] points = new int[][] {{0, 0}, {2, 2}, {3 ,10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        final int N = points.length;
        List<Edge> edges = new ArrayList<>();
        List<Edge> mst = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new Edge(i, j, weight));
            }
        }
        edges.sort(Comparator.comparingInt(e -> e.weight));

        for (int i = 0; i < N; i++) {
            parent.put(i, i);
        }

        int index = 0;
        while (mst.size() != N - 1) {
            Edge nextEdge = edges.get(index++);

            int rootOne = findRootByElement(nextEdge.src);
            int rootTwo = findRootByElement(nextEdge.dest);

            if (rootOne != rootTwo) {
                mst.add(nextEdge);
                parent.put(rootOne, rootTwo);
            }
        }

        return mst.stream().mapToInt(e -> e.weight).sum();
    }

    private static int findRootByElement(int k) {
        if (parent.get(k) == k) return k;
        return findRootByElement(parent.get(k));
    }
}
