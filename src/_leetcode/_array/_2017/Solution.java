package _leetcode._array._2017;

/**
 * @Description: 2017. 网格游戏
 * 给你一个下标从 0 开始的二维数组 grid ，数组大小为 2 x n ，其中 grid[r][c] 表示矩阵中 (r, c) 位置上的点数。现在有两个机器人正在矩阵上参与一场游戏。
 * 两个机器人初始位置都是 (0, 0) ，目标位置是 (1, n-1) 。每个机器人只会 向右 ((r, c) 到 (r, c + 1)) 或 向下 ((r, c) 到 (r + 1, c)) 。
 * 游戏开始，第一个 机器人从 (0, 0) 移动到 (1, n-1) ，并收集路径上单元格的全部点数。对于路径上所有单元格 (r, c) ，途经后 grid[r][c] 会重置为 0 。
 * 然后，第二个 机器人从 (0, 0) 移动到 (1, n-1) ，同样收集路径上单元的全部点数。注意，它们的路径可能会存在相交的部分。
 * 第一个 机器人想要打击竞争对手，使 第二个 机器人收集到的点数 最小化 。与此相对，第二个 机器人想要 最大化 自己收集到的点数。两个机器人都发挥出自己的 最佳水平 的前提下，返回 第二个 机器人收集到的 点数 。
 * @Date: 2021/9/27
 */

public class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] a = new long[n];
        long[] b = new long[n];
        a[0] = grid[0][0];
        b[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + grid[0][i];
            b[i] = b[i - 1] + grid[1][i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long up = a[n - 1] - a[i];
            long down = i == 0 ? 0 : b[i - 1];
            res = Math.min(res, Math.max(up, down));
        }
        return res;
    }
}
