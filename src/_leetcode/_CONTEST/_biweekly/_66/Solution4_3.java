package _leetcode._CONTEST._biweekly._66;

import java.util.Arrays;

/**
 * @Description:
 * @Date: 2021/11/28
 */

public class Solution4_3 {
    // 时间复杂度 O(m * n )
    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];// 以 (i, j) 为顶端的最大的金字塔的高度
        int ans = 0;
        // 金字塔
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    f[i][j] = -1;
                } else if (i == m - 1 || j == 0 || j == n - 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(f[i + 1][j - 1], Math.min(f[i + 1][j], f[i + 1][j + 1])) + 1;
                    ans += f[i][j];
                }
            }
        }
        // 倒金字塔
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    f[i][j] = -1;
                } else if (i == 0 || j == 0 || j == n - 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i - 1][j + 1])) + 1;
                    ans += f[i][j];
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 0, 0, 1}};
        int[][] grid2 = {{0, 1, 1, 0}, {1, 1, 1, 1}};
        System.out.println((new Solution4_3()).countPyramids(grid));
        System.out.println((new Solution4_3()).countPyramids(grid2));
    }

}
