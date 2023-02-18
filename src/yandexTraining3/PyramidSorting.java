package yandexTraining3;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PyramidSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(N);
        for (int i = 0; i < N; i++)
            queue.add(in.nextInt());

        while (!queue.isEmpty()) System.out.println(queue.poll());
    }
}
