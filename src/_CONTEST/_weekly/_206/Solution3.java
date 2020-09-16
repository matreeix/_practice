package _CONTEST._weekly._206;

import java.util.PriorityQueue;

/**
 * @Description: 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，
 * 其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * @Author: matreeix
 * @Date: 2020/9/16
 */

public class Solution3 {
    int[] prts;  //parents for union-find

    public int minCostConnectPoints(int[][] ps) {
        int m = ps.length, islands = m, res = 0, dist[][] = new int[m][m];  // dist is cache for distance of each edge.
        prts = new int[m];
        for (int i = 0; i < m; i++) prts[i] = i;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist[a[0]][a[1]] - dist[b[0]][b[1]]);
        for (int i = 0; i < m; i++)
            for (int j = i + 1; j < m; j++) {
                dist[i][j] = Math.abs(ps[i][0] - ps[j][0]) + Math.abs(ps[i][1] - ps[j][1]);
                pq.offer(new int[]{i, j});
            }
        while (!pq.isEmpty() && islands > 1) {
            int[] p = pq.poll();
            if (union(p[0], p[1])) {
                res += dist[p[0]][p[1]];
                islands--;
            }
        }
        return res;
    }

    private boolean union(int i, int j) {
        int ip = find(i), jp = find(j);
        if (ip == jp) return false;
        prts[ip] = jp;
        return true;
    }

    private int find(int i) {
        int ip = prts[i];
        if (ip != i) {
            prts[i] = find(ip);
        }
        return prts[i];
    }
}
