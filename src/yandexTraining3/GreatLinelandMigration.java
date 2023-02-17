package yandexTraining3;

import java.util.Scanner;
import java.util.Stack;

public class GreatLinelandMigration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Pair> stack = new Stack<>();

        final int N = in.nextInt();
        int[] cities = new int[N];

        for (int i = 0; i < N; i++) {
            cities[i] = in.nextInt();
        }
        in.close();

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek().value > cities[i]) {
                Pair p = stack.pop();
                result[p.index] = i;
            }
            stack.push(new Pair(i, cities[i]));
        }

        while (!stack.isEmpty()) {
            result[stack.pop().index] = -1;
        }

        for (int index : result) {
            System.out.print(index + " ");
        }
    }
}

class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
