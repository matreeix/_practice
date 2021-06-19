package _leetcode._CONTEST._weekly._220;

import java.util.Arrays;

/**
 * @Description: 1697. 检查边长度限制的路径是否存在
 * 给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。
 * 给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，你的任务是对于每个查询 queries[j] ，判断是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。
 * 请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 true 时， answer 第 j 个值为 true ，否则为 false 。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * 1 <= edgeList.length, queries.length <= 105
 * edgeList[i].length == 3
 * queries[j].length == 3
 * 0 <= ui, vi, pj, qj <= n - 1
 * ui != vi
 * pj != qj
 * 1 <= disi, limitj <= 109
 * 两个点之间可能有 多条 边。
 * @Date: 2020/12/23
 */

public class Solution4 {
    int N = 100005;
    int[] p = new int[N];

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        Pair[] pair = new Pair[queries.length];
        // 添加一维index
        for (int i = 0; i < queries.length; i++) {
            pair[i] = new Pair(queries[i][0], queries[i][1], queries[i][2], i);
        }
        // queries 和 edgeList 分别按照边长从小到大排序
        Arrays.sort(pair, (o1, o2) -> (o1.l - o2.l));
        Arrays.sort(edgeList, (o1, o2) -> (o1[2] - o2[2]));
        // 并查集初始化
        for (int i = 1; i < N; i++) {
            p[i] = i;
        }
        int i = 0;
        for (Pair query : pair) {
            int a = query.a;
            int b = query.b;
            int l = query.l;
            int index = query.index;
            for (; i < edgeList.length; i++) {
                if (edgeList[i][2] < l) {
                    p[find(edgeList[i][0])] = find(edgeList[i][1]);//合并
                } else {
                    break;
                }
            }
            //查a和b是否在同一个连通块中
            res[index] = (find(a) == find(b));
        }
        return res;
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}

class Pair {
    int a, b, l, index;

    public Pair(int a, int b, int l, int index) {
        this.a = a;
        this.b = b;
        this.l = l;
        this.index = index;
    }
}


