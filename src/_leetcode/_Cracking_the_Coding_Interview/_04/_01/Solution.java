package _leetcode._Cracking_the_Coding_Interview._04._01;

import java.util.Map;
import java.util.Set;

/**
 * @Description: 面试题 04.01. 节点间通路
 * 节点间通路。给定 有向 图，设计一个算法，找出两个节点之间是否存在一条路径
 * @Author: matreeix
 * @Date: 2020/8/3
 */

public class Solution {
    private boolean[] visited;
    private Map<Integer, Set<Integer>> map;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 路径可达
        boolean[] dp = new boolean[n];

        for (int[] node : graph) {
            // 若出发地为start 则设置出发地到目的地可达
            dp[node[0]] = node[0] == start;
        }

        for (int i = 0; i < graph.length; i++) {
            int[] node = graph[i];
            if (dp[node[0]]) {
                dp[node[1]] = true;
            }
        }
        for (int i = graph.length - 1; i >= 0; i--) {
            int[] node = graph[i];
            if (dp[node[0]]) {
                dp[node[1]] = true;
            }
        }

        return dp[target];
    }

    //妙啊！
    public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        boolean[] reachable = new boolean[n];
        reachable[start] = true;
        int cnt = graph.length;
        while (cnt-- > 0)
            for (int[] edge : graph)
                if (reachable[edge[0]])
                    reachable[edge[1]] = true;

        return reachable[target];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] graph = {{5, 6}, {4, 5}, {3, 4}, {2, 3},{1,2},{0,1}};
        int start = 0, target = 6;

        Solution solution = new Solution();
        System.out.println(solution.findWhetherExistsPath2(n, graph, start, target));
//        int n2 = 12;
//        int[][] graph2 = {{0, 1}, {1, 2}, {1, 3}, {1, 10}, {1, 11}, {1, 4}, {2, 4}, {2, 6}, {2, 9}, {2, 10},
//                {2, 4}, {2, 5}, {2, 10}, {3, 7}, {3, 7}, {4, 5}, {4, 11}, {4, 11}, {4, 10}, {5, 7}, {5, 10}, {6, 8}, {7, 11}, {8, 10}};
//        int start2 = 2;
//        int target2 = 3;
//        System.out.println(solution.findWhetherExistsPath(n2, graph2, start2, target2));

    }
}
