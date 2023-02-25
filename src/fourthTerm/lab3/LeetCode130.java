package fourthTerm.lab3;

import java.util.Arrays;

public class LeetCode130 {

    public static void main(String[] args) {
        char[][] board1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] board2 = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };

        solve(board1);
        Arrays.stream(board1).map(Arrays::toString).forEach(System.out::println);

        System.out.println();

        solve(board2);
        Arrays.stream(board2).map(Arrays::toString).forEach(System.out::println);
    }

    public static void solve(char[][] board) {
        final int M = board.length;
        final int N = board[0].length;
        boolean[][] isUndeletable = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            if(board[i][0] == 'O') update(board, isUndeletable, i, 0, M, N);
            if(board[i][N - 1] == 'O') update(board, isUndeletable, i, N - 1,  M, N);
        }

        for (int i = 1; i < N - 1; i++) {
            if(board[0][i] == 'O') update(board, isUndeletable, 0, i,  M, N);
            if(board[M - 1][i] == 'O') update(board, isUndeletable, M - 1, i,  M, N);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!isUndeletable[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void update(char[][] board, boolean[][] isUndeletable,int i, int j, final int M, final int N) {
        isUndeletable[i][j] = true;
        if((i + 1) < M && board[i + 1][j] == 'O' && !isUndeletable[i + 1][j]) {
            update(board, isUndeletable, i + 1, j, M, N);
        }

        if((i - 1) >= 0 && board[i - 1][j] == 'O' && !isUndeletable[i - 1][j]) {
            update(board, isUndeletable, i - 1, j, M, N);
        }

        if((j - 1) >= 0 && board[i][j - 1] == 'O' && !isUndeletable[i][j - 1]) {
            update(board, isUndeletable, i, j - 1, M, N);
        }

        if((j + 1) < N && board[i][j + 1] == 'O' && !isUndeletable[i][j + 1]) {
            update(board, isUndeletable, i, j + 1, M, N);
        }
    }
}