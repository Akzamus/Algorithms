package fourthTerm.lab3;

public class LeetCode200 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int islandNumber = 0;
        final int M = grid.length;
        final int N = grid[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == '1') {
                    mark(grid, i, j, M, N);
                    islandNumber++;
                }
            }
        }
        return islandNumber;
    }

    private static void mark (char[][] grid, int i, int j, final int M, final int N) {
        grid[i][j] = 'X';

        if((i + 1) < M && grid[i + 1][j] == '1') {
            mark(grid, i + 1, j, M, N);
        }

        if((i - 1) >= 0 && grid[i - 1][j] == '1') {
            mark(grid, i - 1, j, M, N);
        }

        if((j - 1) >= 0 && grid[i][j - 1] == '1') {
            mark(grid, i, j - 1, M, N);
        }

        if((j + 1) < N && grid[i][j + 1] == '1') {
            mark(grid, i, j + 1, M, N);
        }
    }
}
