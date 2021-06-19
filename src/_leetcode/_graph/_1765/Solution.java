package _leetcode._graph._1765;

import javafx.util.Pair;

import java.util.*;

/**
 * @Description: 1765. 地图中的最高点
 * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
 * 1.如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
 * 2.如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
 * 你需要按照如下规则给每个单元格安排高度：
 * <p>
 * 1.每个格子的高度都必须是非负的。
 * 2.如果一个格子是是 水域 ，那么它的高度必须为 0 。
 * 3.任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
 * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
 * 提示：
 * <p>
 * m == isWater.length
 * n == isWater[i].length
 * 1 <= m, n <= 1000
 * isWater[i][j] 要么是 0 ，要么是 1 。
 * 至少有 1 个水域格子。
 * @Date: 2021/2/22
 */

public class Solution {

    private boolean[][] visited;
    private int[][] height;
    private int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};//左，右，上，下
    private int m;
    private int n;
    private int id;

    //单个依次BFS,所有水域一个个遍历会超时
    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;
        height = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (isWater[i][j] == 1) //从水域开始BFS
                    bfs(i, j, isWater);

        return height;
    }

    private void bfs(int x, int y, int[][] isWater) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(x, y));
        visited[x][y] = true;
//        List<String> l = new ArrayList<>();
//        l.add("(" + x + ":" + y + ")");
        int cnt = 1;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.remove();
            int x0 = p.getKey();
            int y0 = p.getValue();
            cnt++;
//            l.add("(" + x0 + ":" + y0 + ")");

            for (int i = 0; i < 4; i++) {
                int xx = x0 + dirs[i][0];
                int yy = y0 + dirs[i][1];
                if (inArea(xx, yy) && !visited[xx][yy]) {
                    if (height[xx][yy] == 0) {//非水域的0区域直接加一
                        height[xx][yy] = isWater[xx][yy] != 1 ? height[x0][y0] + 1 : 0;
                        queue.add(new Pair<>(xx, yy));
                    } else {//已经填充的地方取两个源的最小值
                        if (height[xx][yy] >= height[x0][y0] + 1) {
                            height[xx][yy] = height[x0][y0] + 1;
                            queue.add(new Pair<>(xx, yy));
                        }
                    }
                    visited[xx][yy] = true;
                }
            }
        }
        System.out.println("id:" + id);
        id++;
        deeepTostring(height);
        System.out.println("遍历的点数:" + cnt);
        visited = new boolean[m][n];
    }

    private boolean inArea(int i, int j) {
        return 0 <= i && i < m && 0 <= j && j < n;
    }

    private void deeepTostring(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(Arrays.toString(arrs[i]));
        }
    }

    int[] dir_x = new int[]{-1, 1, 0, 0};
    int[] dir_y = new int[]{0, 0, -1, 1};

    //多源BFS
    public int[][] highestPeak2(int[][] isWater) {
        Queue<Integer> q = new LinkedList<>();
        int row = isWater.length, col = isWater[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    q.offer(i * 10000 + j);//将所有源头都放进队列！！！！！！！
                } else {
                    isWater[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / 10000, y = cur % 10000;
            for (int i = 0; i < 4; i++) {
                int new_x = x + dir_x[i];
                int new_y = y + dir_y[i];
                if (new_x >= 0 && new_y >= 0 && new_x < row
                        && new_y < col && isWater[new_x][new_y] == -1) {
                    isWater[new_x][new_y] = isWater[x][y] + 1;
                    q.offer(new_x * 10000 + new_y);
                }
            }
        }
        return isWater;
    }

    public static void main(String[] args) {
//        int[][] isWater = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
//        int[][] isWater = {{0, 1}, { 0, 0}};
//        int[][] isWater = {{0, 1}, { 0, 1}};
        int[][] isWater = {{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}};
        Solution s = new Solution();
        int[][] res = s.highestPeak(isWater);
//        s.deeepTostring(res);
    }
}
//        [[3,4,4,3,2,1,1,0,1,2,3,4,3,2,1,2,3,4],
//        [2,3,3,2,1,0,1,1,2,3,4,3,2,1,0,1,2,3],
//        [1,2,2,1,0,1,2,2,3,4,5,4,3,2,1,2,3,4],
//
//        [0,1,2,2,1,2,3,3,2,3,4,3,2,3,2,3,4,5],
//        [1,2,3,3,2,1,2,2,1,2,3,2,1,2,3,4,5,6],
//        [2,3,3,2,1,0,1,1,0,1,2,1,0,1,2,3,4,5],
//        [3,2,3,3,2,1,2,1,1,1,2,2,1,2,3,4,5,4],
//        [2,1,2,2,3,2,1,0,1,0,1,2,2,2,3,4,4,3],
//        [1,0,1,1,2,3,2,1,2,1,2,3,2,1,2,3,3,2],
//        [1,0,1,0,1,2,3,2,3,2,3,2,1,0,1,2,2,1],
//        [2,1,2,1,2,3,2,1,2,3,4,3,2,1,2,2,1,0],
//        [1,0,1,2,3,2,1,0,1,2,3,4,3,2,3,3,2,1],
//        [2,1,2,3,4,3,2,1,1,2,3,4,4,3,3,2,1,2],
//        [3,2,3,4,4,3,2,1,0,1,2,3,4,3,2,1,0,1],
//        [4,3,4,5,5,4,3,2,1,2,3,4,5,4,3,2,1,2],
//        [5,4,5,6,6,5,4,3,2,3,4,5,5,4,3,3,2,1],
//        [6,5,6,7,7,6,5,4,3,4,5,5,4,3,2,2,1,0],
//        [7,6,7,8,8,7,6,5,4,5,5,4,3,2,1,2,2,1],
//        [8,7,8,9,9,8,7,6,5,5,4,3,2,1,0,1,2,2]]
