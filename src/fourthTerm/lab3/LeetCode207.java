package fourthTerm.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode207 {

    public static void main(String[] args) {
        int[][] prerequisites = { {1, 0}, {0, 1} };
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;

        if(numCourses == 0 || len == 0) return true;

        int[] visit = new int[numCourses];
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites){
            if (map.containsKey(prerequisite[1])){
                map.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                ArrayList<Integer> dependencies = new ArrayList<>();
                dependencies.add(prerequisite[0]);
                map.put(prerequisite[1], dependencies);
            }
        }

        for(int i = 0; i < numCourses; i++)
            if(!canFinishDFS(map, visit, i))
                return false;

        return true;
    }

    private static boolean canFinishDFS(Map<Integer,ArrayList<Integer>> map, int[] visit, int i){
        if (visit[i] == -1) return false;
        if (visit[i] ==  1) return true;

        visit[i] =- 1;

        if(map.containsKey(i))
            for(int j : map.get(i))
                if(!canFinishDFS(map, visit, j))
                    return false;

        visit[i] = 1;

        return true;
    }
}
