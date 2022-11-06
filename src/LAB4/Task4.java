package LAB4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task4 {

    public int maxProduct(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) queue.offer(num);
        return (queue.poll()-1)*(queue.poll()-1);
    }
}
