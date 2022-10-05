package LAB3;

import java.util.LinkedList;
import java.util.Queue;

public class Task1 {

    class MyStack {

        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        public void push(int x) {
            q2.add(x);

            while (!q1.isEmpty())
                q2.add(q1.remove());

            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        public int pop() {
            return q1.remove();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
