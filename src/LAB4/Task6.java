package LAB4;

import java.util.*;

public class Task6 {

    public int largestInteger(int num) {
        Queue<Integer> oddQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> evenQueue = new PriorityQueue<>(Comparator.reverseOrder());
        char[] digits = String.valueOf(num).toCharArray();

        for (char c : digits) {
            int digit = c - '0';

            switch (digit % 2) {
                case 0 -> evenQueue.offer(digit);
                default -> oddQueue.offer(digit);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : digits) {
            int digit = c - '0';

            result.append(switch (digit % 2) {
                case 0 -> String.valueOf(evenQueue.poll());
                default -> String.valueOf(oddQueue.poll());
            });
        }

        return Integer.parseInt(result.toString());
    }
}
