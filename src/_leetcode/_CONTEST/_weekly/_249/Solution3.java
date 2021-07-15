package _leetcode._CONTEST._weekly._249;

/**
 * @Description: 5811. 用三种不同颜色为网格涂色
 * 给你两个整数 m 和 n 。构造一个 m x n 的网格，其中每个单元格最开始是白色。请你用 红、绿、蓝 三种颜色为每个单元格涂色。所有单元格都需要被涂色。
 * 涂色方案需要满足：不存在相邻两个单元格颜色相同的情况 。返回网格涂色的方法数。因为答案可能非常大， 返回 对 109 + 7 取余 的结果。
 * 提示：
 * 1 <= m <= 5
 * 1 <= n <= 1000
 * @Date: 2021/7/11
 */

public class Solution3 {
    public int[][] memo = new int[1000][1024];
    public int m = 0, n = 0, MOD = 1000000007;


    //动态规划
    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        return dp(0, 0, 0, 0);
    }

    private int dp(int c, int prevColMask, int r, int curColMask) {
        if (c == n) return 1; // Found a valid way
        if (r == 0 && memo[c][prevColMask] != 0) return memo[c][prevColMask];
        if (r == m) return dp(c + 1, curColMask, 0, 0);
        int ans = 0;
        for (int i = 1; i <= 3; ++i) // Try colors i in [1=RED, 2=GREEN, 3=BLUE]
            if (getColor(prevColMask, r) != i && (r == 0 || getColor(curColMask, r - 1) != i))
                ans = (ans + dp(c, prevColMask, r + 1, setColor(curColMask, r, i))) % MOD;
        if (r == 0) memo[c][prevColMask] = ans;
        return ans;
    }

    private int getColor(int mask, int pos) { // Get color of the `mask` at `pos`, use 2 bits to store a color
        return (mask >> (2 * pos)) & 3;
    }

    private int setColor(int mask, int pos, int color) { // Set `color` to the `mask` at `pos`, use 2 bits to store a color
        return mask | (color << (2 * pos));
    }

    //递推法
    public int colorTheGrid2(int m, int n) {
        long[] dp = new long[1001];
        if (m == 1) {
            dp[1] = 3;
            for (int i = 2; i <= n; i++) {
                dp[i] = 2 * dp[i - 1] % 1000000007;
            }
        } else if (m == 2) {
            dp[0] = 2;
            for (int i = 1; i <= n; i++) {
                dp[i] = 3 * dp[i - 1] % 1000000007;
            }
        } else if (m == 3) {
            dp[0] = 3;
            dp[1] = 12;
            for (int i = 2; i <= n; i++) {
                dp[i] = ((5 * dp[i - 1] - 2 * dp[i - 2]) % 1000000007 + 1000000007) % 1000000007;
            }
        } else if (m == 4) {
            dp[0] = 4;
            dp[1] = 24;
            dp[2] = 162;
            for (int i = 3; i <= n; i++) {
                dp[i] = ((9 * dp[i - 1] - 15 * dp[i - 2] + 6 * dp[i - 3]) % 1000000007 + 1000000007) % 1000000007;
            }
        } else {
            dp[0] = 6;
            dp[1] = 48;
            dp[2] = 486;
            dp[3] = 5118;
            dp[4] = 54450;
            for (int i = 5; i <= n; i++) {
                dp[i] = ((16 * dp[i - 1] - 65 * dp[i - 2] + 92 * dp[i - 3] - 48 * dp[i - 4] + 8 * dp[i - 5])
                        % 1000000007 + 1000000007) % 1000000007;
            }
        }
        return (int) dp[n];
    }
}
