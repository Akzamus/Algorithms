package fourthTerm.lab3;

import java.util.*;

public class LeetCode210 {

    private boolean dfs(int u, List<Integer>[] adj, List<Integer> list, int[] visited){
        visited[u] = 1;
        for(int v : adj[u]){
            if(visited[v] == 1) return true;
            if(visited[v] == 0 && dfs(v, adj, list, visited)) return true;
        }
        visited[u] = 2;
        list.add(u);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new LinkedList<>();

        for (int[] courses : prerequisites)
            adj[courses[1]].add(courses[0]);

        List<Integer> list = new LinkedList();
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
            if(visited[i] == 0 && dfs(i, adj, list, visited))
                return new int[0];

        Collections.reverse(list);
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
