package fourthTerm.lab3;

import java.util.Arrays;

public class LeetCode1011 {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays(weights, 5));
    }

    private static int shipWithinDays(int[] weights, int days) {
        int minWeight = Arrays.stream(weights).max().getAsInt();
        int maxWeight = Arrays.stream(weights).sum();
        int result = maxWeight;

        while (minWeight <= maxWeight) {
            int capacity = (minWeight + maxWeight) / 2;

            if (canShip(capacity, weights, days)) {
                result = Math.min(result, capacity);
                maxWeight = capacity - 1;
            } else {
                minWeight = capacity + 1;
            }
        }

        return result;
    }

    private static boolean canShip(int capacity, int[] weights, int days) {
        int numOfDays = 1;
        int currentCapacity = capacity;

        for (int weight : weights) {
            if(currentCapacity - weight < 0) {
                numOfDays++;
                currentCapacity = capacity;
            }
            currentCapacity -= weight;
        }

        return numOfDays <= days;
    }
}
