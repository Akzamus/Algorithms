package yandexTraining3;

import java.util.Scanner;
import java.util.Stack;

public class SortingOfWagonsLite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        int expected = 1;

        for (int i = 0; i < n; i++) {
            int car = scanner.nextInt();
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
            if (car == expected) {
                expected++;
            } else {
                stack.push(car);
            }
        }

        while (!stack.isEmpty() && stack.peek() == expected) {
            stack.pop();
            expected++;
        }
        System.out.println(expected == n + 1 ? "YES" : "NO");
    }
}
