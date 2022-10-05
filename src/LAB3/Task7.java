package LAB3;

import java.util.LinkedList;
import java.util.Queue;

public class Task7 {
    class RecentCounter {

        private Queue<Integer> q = new LinkedList<>();

        public int ping(int t) {
            q.add(t);
            while (q.peek() < t - 3000)
                q.remove();
            return q.size();
        }
    }
}
