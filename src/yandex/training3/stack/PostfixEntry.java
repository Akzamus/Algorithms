package yandex.training3.stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEntry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String[] input = in.nextLine().split(" ");
        in.close();

        for (String str : input) {
            switch (str) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y - x);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                default -> stack.push(Integer.parseInt(str));
            }
        }
        System.out.println(stack.pop());
    }
}
