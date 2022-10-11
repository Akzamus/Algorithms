package LAB4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task7 {

    public int fillCups(int[] amount) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int element : amount) queue.offer(element);
        int seconds = 0;

        for(int first, second; !queue.isEmpty(); seconds++) {
            first = queue.poll();
            second = queue.poll();

            if(first <= 0 && second <= 0) break;

            queue.offer(--first);
            queue.offer(--second);
        }

        return seconds;
    }
}
