package fourthTerm.lab2;

import java.util.*;

public class LeetCode406 {

    public static void main(String[] args) {
        int arr[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        arr = reconstructQueue(arr);
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[list.size()][]);
    }
}
