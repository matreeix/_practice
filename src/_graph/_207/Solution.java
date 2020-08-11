package _graph._207;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Description:判断学习计划能否完成，有环就不能完成
 * @Author: caffebaby
 * @Date: 2020/2/14
 */
public class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];//记录路径
        boolean hasCycle = false;

        TreeSet<Integer>[] adj = new TreeSet[numCourses];//存储邻接顶点
        for (int i = 0; i < numCourses; i++)
            adj[i] = new TreeSet<Integer>();//初始化
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);//记录邻边
        }

        for (int v = 0; v < numCourses; v++)
            if (!visited[v])
                if (dfs(v, visited, onPath, adj)) {
                    hasCycle = true;
                    break;
                }
        return !hasCycle;
    }

    // 从顶点v开始，判断图中是否有环
    private static boolean dfs(int v, boolean[] visited, boolean[] onPath, TreeSet<Integer>[] adj) {
        visited[v] = true;
        onPath[v] = true;
        for (int w : adj[v])
            if (!visited[w]) {
                if (dfs(w, visited, onPath, adj)) return true;
            } else if (onPath[w])
                return true;
        onPath[v] = false;
        return false;
    }

    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

}
