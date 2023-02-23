package yandex.training3.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class SumInRectangle {

    private static int[][] sumMatrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = Arrays.stream(in.nextLine().split(" "))
                               .mapToInt(str -> Integer.parseInt(str))
                               .toArray();
        final int N = input[0];
        final int M = input[1];
        final int K = input[2];

        int[][] matrix = new int[N][M];
        int[][] requests = new int[K][4];


        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(in.nextLine().split(" "))
                              .mapToInt(str -> Integer.parseInt(str))
                              .toArray();
        }

        for (int i = 0; i < K; i++) {
            requests[i] = Arrays.stream(in.nextLine().split(" "))
                                .mapToInt(str -> Integer.parseInt(str) - 1)
                                .toArray();
        }

        in.close();

        processRequests(matrix, requests);
    }

    private static void processRequests(int[][] matrix, int[][] requests) {
        sumMatrix = preprocess(matrix);
        // x1 y1 x2 y2
        for (int[] request : requests) {
            int minX = Math.min(request[0], request[2]);
            int maxX = Math.max(request[0], request[2]);
            int minY, maxY;
            if(minX == request[0]) {
                minY = request[1];
                maxY = request[3];
            } else {
                minY = request[3];
                maxY = request[1];
            }
            System.out.println(findSubMatrixSum(minX, minY, maxX, maxY));
        }
    }

    public static int findSubMatrixSum(int minX, int minY, int maxX, int maxY) {
        int total = sumMatrix[maxX][maxY];

        if (minY - 1 >= 0) total -= sumMatrix[maxX][minY - 1];
        if (minX - 1 >= 0) total -= sumMatrix[minX - 1][maxY];
        if (minX - 1 >= 0 && minY - 1 >= 0) total += sumMatrix[minX - 1][minY - 1];

        return total;
    }

    public static int[][] preprocess(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] sumMatrix = new int[N][M];
        sumMatrix[0][0] = matrix[0][0];

        for (int j = 1; j < M; j++)
            sumMatrix[0][j] = matrix[0][j] + sumMatrix[0][j - 1];

        for (int i = 1; i < N; i++)
            sumMatrix[i][0] = matrix[i][0] + sumMatrix[i - 1][0];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                sumMatrix[i][j] = matrix[i][j] + sumMatrix[i - 1][j]
                                         + sumMatrix[i][j - 1]
                                         - sumMatrix[i - 1][j - 1];
            }
        }
        return sumMatrix;
    }
}
