package fourthTerm.lab4;

public class LeetCode785 {

    boolean isBipartite = true;
    int[] visited;
    int graph[][];
    int n;

    public boolean isBipartite(int[][] g) {
        n = g.length;
        graph = g;
        visited = new int[n];

        for (int i = 0; i <= n; i++) {
            if(visited[i] == 0) dfs(i, 1);
        }

        return isBipartite;
    }

    private void dfs(int vertex, int color) {
        if(!isBipartite) return;
        visited[vertex] = color;

        for (int next : graph[vertex]) {
            if(visited[next] == 0) dfs(next, 3 - color);
            if(visited[next] == visited[vertex]) isBipartite = false;
        }
    }
}
