package LAB2;

import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Random random = new Random();
        int len = 1_000_000;
        String[] arr = new String[len];

        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(random.nextInt(100_000, 1_000_000));
        }

        long start, end;

        start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            arr[i].length();
        }
        end = System.currentTimeMillis();
        System.out.println("length() " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            arr[i].substring(1);
        }
        end = System.currentTimeMillis();
        System.out.println("substring(x) " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            arr[i].substring(1, 4);
        }
        end = System.currentTimeMillis();
        System.out.println("substring(x, y) " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            Integer.valueOf(arr[i]);
        }
        end = System.currentTimeMillis();
        System.out.println("Integer.valueOf() " + (end - start));
    }
}
