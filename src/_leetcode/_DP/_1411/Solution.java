package _leetcode._DP._1411;

/**
 * @Description: 1411. 给 N x 3 网格图涂色的方案数
 * 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
 * 给你网格图的行数 n 。
 * 请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
 * @Date: 2021/7/18
 */

public class Solution {
    public int numOfWays(int n) {
        int[][][][] dp = new int[n + 1][4][4][4];
        return dfs(n, 0, 0, 0, dp);
    }

    // dfs(n, a0, b0, c0) is the number of ways to color the first n rows of the grid
    //      keeping in mind that the previous row (n + 1) has colors a0, b0 and c0
    int dfs(int n, int a0, int b0, int c0, int[][][][] dp) {
        if (n == 0) return 1;
        if (dp[n][a0][b0][c0] != 0) return dp[n][a0][b0][c0];
        int ans = 0;
        int[] colors = new int[]{1, 2, 3}; // Red: 1, Yellow: 2, Green: 3
        for (int a : colors) {
            if (a == a0) continue; // Check if the same color with the below neighbor
            for (int b : colors) {
                if (b == b0 || b == a) continue; // Check if the same color with the below neighbor or the left neighbor
                for (int c : colors) {
                    if (c == c0 || c == b)
                        continue; // Check if the same color with the below neighbor or the left neighbor
                    ans += dfs(n - 1, a, b, c, dp);
                    ans %= 1000_000_007;
                }
            }
        }
        return dp[n][a0][b0][c0] = ans;
    }

    static final int MOD = 1000000007;

    public int numOfWays2(int n) {
        long fi0 = 6, fi1 = 6;
        for (int i = 2; i <= n; ++i) {
            long newFi0 = (2 * fi0 + 2 * fi1) % MOD;
            long newFi1 = (2 * fi0 + 3 * fi1) % MOD;
            fi0 = newFi0;
            fi1 = newFi1;
        }
        return (int) ((fi0 + fi1) % MOD);
    }

}
