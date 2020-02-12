package _graph._210;

import java.util.*;

/**
 * @Description: 按顺序完成课程（拓扑排序）
 * @Author: 67ng
 * @Date: 2020/2/12
 */
public class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        ArrayList<Integer> res = new ArrayList<>();
        int[] res = new int[numCourses];
        Arrays.fill(res, -1);
        TreeSet<Integer>[] adj = new TreeSet[numCourses];//存储邻接顶点
        for (int i = 0; i < numCourses; i++)
            adj[i] = new TreeSet<Integer>();//初始化

        int[] indegrees = new int[numCourses];//存储每个顶点的入度
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;//记录入度
            adj[prerequisites[i][1]].add(prerequisites[i][0]);//记录邻边
        }
        for (int i : indegrees)
            if (indegrees[i] == 0) q.add(i);

        int i = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            res[i++] = cur;

            for (int next : adj[cur]) {
                indegrees[next]--;
                if (indegrees[next] == 0) q.add(next);
            }
        }

        if (res[numCourses-1] == -1) {
            res = new int[numCourses];
        }
        return res;
    }

//    //顶点v的邻接点
//    public static Iterable<Integer> getAdj(int v){
//        return adj[v];
//    }

    public static void main(String[] args) {
//        int numCourses = 2;
//        int[][] prerequisites = {{1, 0}};

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
//        System.out.println(findOrder(numCourses, prerequisites));
    }

}
