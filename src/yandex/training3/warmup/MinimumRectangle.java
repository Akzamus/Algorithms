package yandex.training3.warmup;

import java.util.*;

public class MinimumRectangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        int[][] points = new int[k][2];

        for (int i = 0; i < k; i++) {
            points[i] = Arrays.stream(in.nextLine().split(" "))
                              .mapToInt(str -> Integer.parseInt(str))
                              .toArray();
        }

        in.close();

        printMinimalRectanglePoints(points);
    }

    public static void printMinimalRectanglePoints(int[][] points) {
        Map<Integer, Set<Integer>> yOnX = new HashMap<>();

        for (int[] p : points) {
            yOnX.putIfAbsent(p[0], new HashSet<>());
            yOnX.get(p[0]).add(p[1]);
        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Set<Integer>> entry : yOnX.entrySet()) {
            int x = entry.getKey();
            if(x > maxX) maxX = x;
            if(x < minX) minX = x;
            for (int y : entry.getValue()) {
                if(y > maxY) maxY = y;
                if(y < minY) minY = y;
            }
        }
        System.out.println(String.format("%d %d %d %d", minX, minY, maxX, maxY));
    }
}
