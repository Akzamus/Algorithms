package yandexTraining3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackWithErrorProtection {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List<String[]> input = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String command;
        int value = 0;

        while (true) {
            String str = in.nextLine();
            input.add(str.split(" "));
            if(str.equals("exit")) break;
        }

        for(String[] arr : input) {
            command = arr[0];
            if(arr.length == 2) value = Integer.parseInt(arr[1]);

            switch (command) {

                case "push" -> {
                    stack.push(value);
                    System.out.println("ok");
                }

                case "pop" -> {
                    if(!stack.isEmpty()) System.out.println(stack.pop());
                    else                  System.out.println("error");
                }

                case "back" -> {
                    if(!stack.isEmpty()) System.out.println(stack.peek());
                    else                  System.out.println("error");
                }

                case "clear" -> {
                    stack.clear();
                    System.out.println("ok");
                }

                case "size" -> System.out.println(stack.size());

                case "exit" -> System.out.println("bye");
            }
        }
    }
}
