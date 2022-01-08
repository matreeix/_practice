package _leetcode._DP._377;

/**
 * @Description: 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * @Date: 2021/12/31
 */

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++)
            for (int num : nums)
                if (i >= num)
                    dp[i] += dp[i - num];
        return dp[target];
    }
}
