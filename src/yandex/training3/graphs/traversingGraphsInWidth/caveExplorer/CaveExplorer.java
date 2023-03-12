package yandex.training3.graphs.traversingGraphsInWidth.caveExplorer;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class CaveExplorer {
    private static int[] dx = {-1, 0, 1, 0, 0, 0};
    private static int[] dy = {0, 1, 0, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static final String inputPath = "src/yandex/training3/graphs/traversingGraphsInWidth/caveExplorer/input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        final int N = Integer.parseInt(reader.readLine());
        char[][][] cave = new char[N][N][N];
        int startX = -1, startY = -1, startZ = -1;

        for (int z = 0; z < N; z++) {
            reader.readLine();
            for (int y = 0; y < N; y++) {
                String row = reader.readLine();
                for (int x = 0; x < N; x++) {
                    cave[z][y][x] = row.charAt(x);
                    if (cave[z][y][x] == 'S') {
                        startX = x;
                        startY = y;
                        startZ = z;
                    }
                }
            }
        }
        reader.close();

        int[][][] dist = new int[N][N][N];

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qz = new LinkedList<>();

        qx.offer(startX);
        qy.offer(startY);
        qz.offer(startZ);

        dist[startZ][startY][startX] = 1;

        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            int z = qz.poll();

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (
                    nx >= 0 && nx < N &&
                    ny >= 0 && ny < N &&
                    nz >= 0 && nz < N &&
                    cave[nz][ny][nx] == '.' && dist[nz][ny][nx] == 0
                ) {
                    qx.offer(nx);
                    qy.offer(ny);
                    qz.offer(nz);
                    dist[nz][ny][nx] = dist[z][y][x] + 1;
                }
            }
        }

        int ans = dist[0][0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cave[0][i][j] == '.' && dist[0][i][j] > 0
                        && (ans == 0 || dist[0][i][j] < ans)) {
                    ans = dist[0][i][j];
                }
            }
        }
        System.out.println(ans - 1);
    }
}
