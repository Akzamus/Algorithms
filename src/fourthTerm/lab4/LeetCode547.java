package fourthTerm.lab4;

public class LeetCode547 {
    private boolean[] visited;
    private int[][] adjMatrix;
    private int n;

    public int findCircleNum(int[][] isConnected) {
        adjMatrix = isConnected;
        n = isConnected.length;
        visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        return result;
    }

    private  void dfs(int v) {
        visited[v] = true;
        for(int i = 0; i < n; i++)
            if (adjMatrix[v][i] == 1 && !visited[i]) dfs(i);
    }
}