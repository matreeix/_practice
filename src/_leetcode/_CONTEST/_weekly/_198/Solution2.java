package _leetcode._CONTEST._weekly._198;

import java.util.*;

/**
 * @Description: 5465. 子树中标签相同的节点数
 * 给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。
 * 树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）
 * 边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。
 * 返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。
 * 树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。
 * @Author: matreeix
 * @Date: 2020/7/19
 */

public class Solution2 {

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
        }
        int[] ans = new int[n];
        dfs(g, 0, -1, labels, ans);
        return ans;
    }

    //得到相应字符的统计总数
    private static int[] dfs(Map<Integer, List<Integer>> g, int node, int parent, String labels, int[] ans) {
        int[] cnt = new int[26];//cnt[i]是相应字符的总数；
        char c = labels.charAt(node);
        for (int child : g.getOrDefault(node, Collections.emptyList())) {
             if (child != parent) {
                int[] sub = dfs(g, child, node, labels, ans);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += sub[i];
                }
            }
        }
        ans[node] = ++cnt[c - 'a'];
        return cnt;
    }


    public static void main(String[] args) {
//        int n = 7;
//        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
//        String labels = "abaedcd";

//        int n = 4;
//        int[][] edges = {{0, 1}, {1, 2}, {0, 3}};
//        String labels = "bbbb";

        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        String labels = "aaabaaa";

        System.out.println(countSubTrees(n, edges, labels));


    }
}
