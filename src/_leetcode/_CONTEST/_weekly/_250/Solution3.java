package _leetcode._CONTEST._weekly._250;

import java.util.Arrays;

/**
 * @Description: 1937. 扣分后的最大得分
 * 给你一个 m x n 的整数矩阵 points （下标从 0 开始）。一开始你的得分为 0 ，你想最大化从矩阵中得到的分数。
 * 你的得分方式为：每一行 中选取一个格子，选中坐标为 (r, c) 的格子会给你的总得分 增加 points[r][c] 。
 * 然而，相邻行之间被选中的格子如果隔得太远，你会失去一些得分。对于相邻行 r 和 r + 1 （其中 0 <= r < m - 1），选中坐标为 (r, c1) 和 (r + 1, c2) 的格子，你的总得分 减少 abs(c1 - c2) 。
 * 请你返回你能得到的 最大 得分。
 * <p>
 * 提示：
 * m == points.length
 * n == points[r].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 0 <= points[r][c] <= 10^5
 * @Date: 2021/7/19
 */

public class Solution3 {
    public long maxPoints(int[][] p) {
        long[] cur_row = new long[p[0].length], prev_row = new long[p[0].length];
        for (int[] row : p) {
            long run_max = 0;
            for (int j = 0; j < row.length; ++j) {
                run_max = Math.max(run_max - 1, prev_row[j]);
                cur_row[j] = run_max;
            }
            for (int j = row.length - 1; j >= 0; --j) {
                run_max = Math.max(run_max - 1, prev_row[j]);
                cur_row[j] = Math.max(cur_row[j], run_max) + row[j];
            }
            prev_row = cur_row;
        }
        return Arrays.stream(prev_row).max().getAsLong();
    }

    public long maxPoints2(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] currRow = new long[n];
        for (int j = 0; j < n; j++) {
            currRow[j] = points[0][j];
        }
        long[] maxLeft = new long[n]; // points[i][j] + j
        long[] maxRight = new long[n]; // points[i][j] - j

        for (int i = 1; i < m; i++) {
            maxLeft[0] = currRow[0];
            for (int j = 1; j < n; j++) {
                maxLeft[j] = Math.max(maxLeft[j - 1], currRow[j] + j);
            }
            maxRight[n - 1] = currRow[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                maxRight[j] = Math.max(maxRight[j + 1], currRow[j] - j);
            }
            for (int j = 0; j < n; j++) {
                currRow[j] = Math.max(points[i][j] + j + maxRight[j], points[i][j] - j + maxLeft[j]);
            }
        }
        return Arrays.stream(currRow).max().getAsLong();
    }
}