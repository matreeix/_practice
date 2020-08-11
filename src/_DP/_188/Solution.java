package _DP._188;

/**
 * @Name: 188.买卖股票的最佳时机 IV
 * @Description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author: caffebaby
 * @Date: 2020/4/13
 */
public class Solution {

    public int maxProfit4(int k, int[] prices) {
        if (prices.length == 0 || k <= 0) return 0;
        int n = prices.length;
        if (k > n / 2)
            return maxProfit2(prices);//对应max_k取无穷大的情况

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++)
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    /*处理 base case */
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        return dp[n - 1][k][0];
    }

    //贪心算法解决不限交易次数
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int minnumber = prices[0];
        int sum = 0;//阶段上升时的最大利润
        int res = 0;//总的最大利润
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] > prices[i]) {
                res += sum;
                sum = 0;
                minnumber = prices[i];
            } else {
                sum = prices[i] - minnumber;
            }
        }
        res += sum;
        return res;
    }


}
