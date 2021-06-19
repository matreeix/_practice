package _leetcode._DP._64;

/**
 * @Description: 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @Author: matreeix
 * @Date: 2020/6/30
 */

public class Solution {
    //dp,在原数组上存储可以让空间复杂度降到O(1)
    public int minPathSum(int[][] grid) {

        int m = grid.length;//row
        int n = grid[0].length;//col
        int[][] mem = new int[m][n];//记忆化数组

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    mem[i][j] = grid[i][j];
                else if (i == 0 && j > 0)
                    mem[i][j] = mem[i][j - 1] + grid[i][j];
                else if (j == 0 && i > 0)
                    mem[i][j] = mem[i - 1][j] + grid[i][j];
                else
                    mem[i][j] = Math.min(mem[i - 1][j], mem[i][j - 1]) + grid[i][j];
            }
        }
        return mem[m - 1][n - 1];
    }

    //最优解法，0m
    public int minPathSum2(int[][] grid) {
        int n = grid.length;
        int k = grid[0].length;
        int[][] memo = new int[n + 1][k + 1];

        return dfs(grid, 0, 0, memo);
    }

    private int dfs(int[][] grid, int i, int j, int[][] memo) {
        // handle OOB -> +ve inf
        // reached bottom right -> 0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        if (memo[i][j] != 0)
            return memo[i][j];

        // go right
        // go down
        int res = Math.min(dfs(grid, i + 1, j, memo), dfs(grid, i, j + 1, memo));

        // pick minimum + current node
        memo[i][j] = res + grid[i][j];
        return memo[i][j];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        Solution s = new Solution();
        System.out.println(s.minPathSum(grid));//1→3→1→1→1
    }
}
