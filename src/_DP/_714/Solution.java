package _DP._714;

/**
 * @Name: 714.买卖股票的最佳时机含手续费
 * @Description: 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 *
 * @date: 2019/3/17 16:52
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1)
            return 0;

        int[] hold = {-prices[0], 0};//成本
        int[] cash = {0, 0};//利润
        for (int i = 1; i < prices.length; i++) {
            hold[i % 2] = Math.max(hold[(i - 1) % 2], cash[(i - 1) % 2] - prices[i]);
            cash[i % 2] = Math.max(cash[(i - 1) % 2], hold[(i - 1) % 2] + prices[i] - fee);
        }
        return cash[(prices.length - 1) % 2];

    }

    public int maxProfitWithFee(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);//在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] price = {1, 3, 2, 8, 4, 9};
        System.out.println(new Solution().maxProfit(price, 2));
    }
}
