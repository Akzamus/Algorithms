package LAB2;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 200);
        }

        System.out.println(search(arr, 5, 10));

    }

    public static int search(int[] arr, int from, int to) {
        long start = System.currentTimeMillis();

        //best O(1) worst O(n)
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= from && arr[i] < to) {
                long end = System.currentTimeMillis();
                System.out.println(end - start);
                return i;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return -1;
    }
}
