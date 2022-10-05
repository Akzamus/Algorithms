package LAB3;

import java.util.LinkedList;
import java.util.Queue;

public class Task8 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();

        for (int value : students) {
            queue.add(value);
        }

        int index = 0;
        int numHungryStudents = 0;

        while (!queue.isEmpty() && numHungryStudents != queue.size()) {
            if (sandwiches[index] == queue.peek()) {
                numHungryStudents = 0;
                index++;
                queue.remove();
            } else {
                numHungryStudents++;
                queue.add(queue.poll());
            }
        }

        return numHungryStudents;
    }
}
