package yandex.training3.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueWithErrorProtection {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();


        while (true) {
            switch (in.next()) {
                case "push" -> {
                    queue.add(in.nextInt());
                    System.out.println("ok");
                }

                case "pop" -> {
                    if(queue.isEmpty()) System.out.println("error");
                    else                System.out.println(queue.poll());
                }

                case "front" -> {
                    if(queue.isEmpty()) System.out.println("error");
                    else                System.out.println(queue.peek());
                }

                case "size" -> System.out.println(queue.size());

                case "clear" -> {
                    queue.clear();
                    System.out.println("ok");
                }

                case "exit" -> {
                    System.out.println("bye");
                    in.close();
                    System.exit(0);
                }
            }
        }
    }
}
