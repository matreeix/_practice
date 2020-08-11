package _DP._1137;

/**
 * @Description: 泰波那契数
 * @Author: caffebaby
 * @Date: 2020/4/22
 */
public class Solution {
    //动态计算，时间复杂度O(n)，空间复杂度O(1)
    public int tribonacci(int n) {
        if (n < 3) return n == 0 ? 0 : 1;

        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;
    }

    //DP
    public int tribonacci2(int n) {
        int[] dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        return dp[n];
    }
}
