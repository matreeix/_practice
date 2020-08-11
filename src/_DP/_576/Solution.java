package _DP._576;

/**
 * @Description: 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，
 * 或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。
 * 找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值
 * @Author: caffebaby
 * @Date: 2020/4/27
 */
public class Solution {
    public int findPaths(int m, int n, int N, int x, int y) {
        int MOD = 1000000007;
        if (N == 0) {
            return 0;
        }

        long[][][] dp = new long[m + 2][n + 2][N + 1];
        for (int i = 0; i <= m + 1; i++) {
            dp[i][0][0] = 1;
            dp[i][n + 1][0] = 1;
        }
        for (int i = 0; i <= n + 1; i++) {
            dp[0][i][0] = 1;
            dp[m + 1][i][0] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j][k] = (dp[i - 1][j][k - 1] + dp[i + 1][j][k - 1] +
                            dp[i][j - 1][k - 1] + dp[i][j + 1][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int k = 1; k <= N; k++) {
            sum = (sum + (int) dp[x + 1][y + 1][k]) % MOD;
        }
        return sum;
    }


}
