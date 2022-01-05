package _leetcode._DP._322;

import java.util.Arrays;

/**
 * @Description: 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * @Date: 2021/12/31
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        for (int coin : coins)
            if (coin < dp.length)
                dp[coin] = 1;
        for (int i = 1; i < dp.length; i++)
            for (int coin : coins)
                if (i - coin >= 0 && dp[i - coin] != 10001)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}
