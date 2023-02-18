package yandexTraining3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecWithErrorProtection {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();


        while (true) {
            switch (in.next()) {
                case "push_front" -> {
                    deque.addFirst(in.nextInt());
                    System.out.println("ok");
                }

                case "push_back" -> {
                    deque.addLast(in.nextInt());
                    System.out.println("ok");
                }

                case "pop_front" -> {
                    if(deque.isEmpty()) System.out.println("error");
                    else                System.out.println(deque.pollFirst());
                }

                case "pop_back" -> {
                    if(deque.isEmpty()) System.out.println("error");
                    else                System.out.println(deque.pollLast());
                }

                case "front" -> {
                    if(deque.isEmpty()) System.out.println("error");
                    else                System.out.println(deque.peekFirst());
                }

                case "back" -> {
                    if(deque.isEmpty()) System.out.println("error");
                    else                System.out.println(deque.peekLast());
                }

                case "size" -> System.out.println(deque.size());

                case "clear" -> {
                    deque.clear();
                    System.out.println("ok");
                }

                case "exit" -> {
                    System.out.println("bye");
                    System.exit(0);
                }
            }
        }
    }
}
