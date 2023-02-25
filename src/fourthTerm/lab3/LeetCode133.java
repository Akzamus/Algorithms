package fourthTerm.lab3;

import java.util.*;

public class LeetCode133 {

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
