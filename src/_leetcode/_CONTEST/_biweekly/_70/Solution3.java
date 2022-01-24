package _leetcode._CONTEST._biweekly._70;

import java.util.*;

/**
 * @Description: 2146. 价格范围内最高排名的 K 样物品
 * 给你一个下标从 0 开始的二维整数数组 grid ，它的大小为 m x n ，表示一个商店中物品的分布图。数组中的整数含义为：
 * 0 表示无法穿越的一堵墙。
 * 1 表示可以自由通过的一个空格子。
 * 所有其他正整数表示该格子内的一样物品的价格。你可以自由经过这些格子。
 * 从一个格子走到上下左右相邻格子花费 1 步。
 * <p>
 * 同时给你一个整数数组 pricing 和 start ，其中 pricing = [low, high] 且 start = [row, col] ，表示你开始位置为 (row, col) ，同时你只对物品价格在 闭区间 [low, high] 之内的物品感兴趣。同时给你一个整数 k 。
 * 你想知道给定范围 内 且 排名最高 的 k 件物品的 位置 。排名按照优先级从高到低的以下规则制定：
 * <p>
 * 距离：定义为从 start 到一件物品的最短路径需要的步数（较近 距离的排名更高）。
 * 价格：较低 价格的物品有更高优先级，但只考虑在给定范围之内的价格。
 * 行坐标：较小 行坐标的有更高优先级。
 * 列坐标：较小 列坐标的有更高优先级。
 * 请你返回给定价格内排名最高的 k 件物品的坐标，将它们按照排名排序后返回。如果给定价格内少于 k 件物品，那么请将它们的坐标 全部 返回。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 0 <= grid[i][j] <= 10^5
 * pricing.length == 2
 * 2 <= low <= high <= 10^5
 * start.length == 2
 * 0 <= row <= m - 1
 * 0 <= col <= n - 1
 * grid[row][col] > 0
 * 1 <= k <= m * n
 * @Date: 2022/1/24
 */

public class Solution3 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int dis = 0;

        Queue<Items> q = new LinkedList<>();
        PriorityQueue<Items> qRes = new PriorityQueue<>(
                (i1, i2) -> i1.dis != i2.dis ? i1.dis - i2.dis
                        : i1.price != i2.price ? i1.price - i2.price
                        : i1.row != i2.row ? i1.row - i2.row
                        : i1.col - i2.col);
        q.add(new Items(start[0], start[1], grid[start[0]][start[1]], dis));
        grid[start[0]][start[1]] = 0;//走过的地方置为0
        while (!q.isEmpty()) {
            int size = q.size();
            dis++;
            while (size-- > 0) {
                Items items = q.poll();
                if (pricing[0] <= items.price && items.price <= pricing[1]) qRes.add(items);
                int col = items.col;
                int row = items.row;

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (0 <= newRow && newRow < m
                            && 0 <= newCol && newCol < n
                            && grid[newRow][newCol] > 0) {
                        q.add(new Items(newRow, newCol, grid[newRow][newCol], dis));
                        grid[newRow][newCol] = 0;//走过的地方置为0
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !qRes.isEmpty()) {
            Items items = qRes.poll();
            res.add(new ArrayList<Integer>() {{
                add(items.row);
                add(items.col);
            }});
        }
        return res;
    }

    public static class Items {
        public int row;
        public int col;
        public int price;
        public int dis;

        public Items(int row, int y, int price, int dis) {
            this.row = row;
            this.col = y;
            this.price = price;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 0, 1}, {1, 3, 0, 1}, {0, 2, 5, 1}};
        int[] prices = {2, 5};
        int[] start = {0, 0};
        int k = 3;
        System.out.println((new Solution3()).highestRankedKItems(grid, prices, start, k));
    }
}
