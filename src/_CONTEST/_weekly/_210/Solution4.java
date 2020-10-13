package _CONTEST._weekly._210;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 5538. 统计子树中城市之间最大距离
 * 给你 n 个城市，编号为从 1 到 n 。同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和 vi 之间有一条双向边。
 * 题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。
 * 一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。
 * 对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。
 * 请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。
 * <p>
 * 请注意，两个城市间距离定义为它们之间需要经过的边的数目。
 * @Author: matreeix
 * @Date: 2020/10/11
 */

public class Solution4 {
    int[][] dist;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        //precalculate the distance of any two cities
        dist = new int[n][n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            calcDist(graph, i, -1, i, 0);
        }
        int[] res = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            int maxDist = 0;
            int oneDistCount = 0;
            int cities = 0;
            //find the max distance between each pair of cities
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    cities++;
                    for (int k = j + 1; k < n; k++) {
                        if ((i & (1 << k)) != 0) {
                            maxDist = Math.max(maxDist, dist[j][k]);
                            if (dist[j][k] == 1) {
                                oneDistCount++;
                            }
                        }
                    }
                }
            }
            //x cities form a substree if and only if there are x-1 edges among these cities
            if (oneDistCount == cities - 1 && maxDist > 0) res[maxDist - 1]++;
        }
        return res;
    }

    public void calcDist(List<Integer>[] graph, int source, int prev, int cur, int d) {
        if (prev == cur) {
            return;
        }
        dist[source][cur] = d;
        dist[cur][source] = d;
        for (int next : graph[cur])
            if (next != prev) {
                calcDist(graph, source, cur, next, d + 1);
            }
    }
}
