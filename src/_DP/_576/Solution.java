package _DP._576;

/**
 * @Description:
 * @Author: 67ng
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
