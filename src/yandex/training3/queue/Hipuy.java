package yandex.training3.queue;

import java.util.*;

public class Hipuy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        final int N = Integer.parseInt(in.nextLine());

        for (int i = 0; i < N; i++) {
            String[] arr = in.nextLine().split(" ");
            if(arr.length == 1) System.out.println(queue.poll());
            else                queue.add(Integer.parseInt(arr[1]));
        }

        in.close();
    }
}