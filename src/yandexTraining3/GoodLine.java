package yandexTraining3;

import java.util.*;
import java.util.stream.Collectors;

public class GoodLine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        int[] quantity = new int[N];

        for (int i = 0; i < N; i++) {
            quantity[i] = in.nextInt();
        }
        in.close();

        int result = 0;
        int numZeros = 0;

        while (numZeros != N) {
            int count = 0;
            numZeros = 0;

            for (int i = 0; i < N; i++) {
                if (quantity[i] != 0) {
                    quantity[i]--;
                    count++;
                } else {
                    numZeros++;
                    if(count > 1) result += count - 1;
                    count = 0;
                }
            }

            if(count > 1) result += count - 1;
        }

        System.out.println(result);
    }
}

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        int[] quantity = new int[N];
    }
}

