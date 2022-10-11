package LAB4;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1});
    }

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> stonesQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
            stonesQueue.add(stone);
        System.out.println(stonesQueue);

        while (stonesQueue.size() >= 2) {
            int stoneOne = stonesQueue.poll();
            int stoneTwo = stonesQueue.poll();
            if(stoneOne != stoneTwo) {
                stonesQueue.add(Math.abs(stoneOne - stoneTwo));
            }
        }

        if(stonesQueue.isEmpty()) return 0;
        return stonesQueue.peek();
    }
}
