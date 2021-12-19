package _leetcode._CONTEST._weekly._272;

/**
 * @Description: 5958. 股票平滑下跌阶段的数目
 * 给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
 * 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
 * 请你返回 平滑下降阶段 的数目。
 * 提示：
 * 1 <= prices.length <= 10^5
 * 1 <= prices[i] <= 10^5
 * @Date: 2021/12/19
 */

public class Solution3 {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int start = 0;
        for (int i = 1; i <= prices.length; i++) {
            if ((i < prices.length && prices[i] != prices[i - 1] - 1) || i == prices.length) {
                int n = i - start;
                start = i;
                res += (long) (n + 1) * n / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {3};
//        int[] prices = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7};// 55+3+10
        System.out.println((new Solution3()).getDescentPeriods(prices));
    }
}
