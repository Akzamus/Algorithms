package yandex.training3.graphs.traversingGraphsInWidth.subway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Subway {
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInWidth/subway/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        final int N = Integer.parseInt(reader.readLine());
        final int M = Integer.parseInt(reader.readLine());

        int[][] lines = reader.lines()
                .limit(M)
                .map(s -> Arrays.stream(s.split(" "))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .toArray()
                )
                .toArray(int[][]::new);

        String[] tokens = reader.readLine().split(" ");
        final int START = Integer.parseInt(tokens[0]);
        final int END = Integer.parseInt(tokens[1]);

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] line = lines[i];
            for (int j = 0; j < line.length; j++) {
                int u = line[j];
                for (int k = j+1; k < line.length; k++) {
                    int v = line[k];
                    adj.get(u).add(new Edge(v, i));
                    adj.get(v).add(new Edge(u, i));
                }
            }
        }

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(START, -1, 0));
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            State s = q.poll();
            int u = s.station;
            int line = s.line;
            int numTransfers = s.numTransfers;
            if (u == END) {
                System.out.println(numTransfers - 1);
                return;
            }
            if (visited.contains(u)) {
                continue;
            }
            visited.add(u);
            for (Edge e : adj.get(u)) {
                int v = e.to;
                int l = e.line;
                if (l != line) {
                    q.offer(new State(v, l, numTransfers+1));
                } else {
                    q.offer(new State(v, line, numTransfers));
                }
            }
        }

        System.out.println(-1);
    }

    private static class Edge {
        int to;
        int line;

        public Edge(int to, int line) {
            this.to = to;
            this.line = line;
        }
    }

    private static class State {
        int station;
        int line;
        int numTransfers;

        public State(int station, int line, int numTransfers) {
            this.station = station;
            this.line = line;
            this.numTransfers = numTransfers;
        }
    }
}
