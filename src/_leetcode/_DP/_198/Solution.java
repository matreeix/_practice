package _leetcode._DP._198;

/**
 * @description ：打家劫舍1
 * @date ： 2020-04-10
 */
public class Solution {
    //动态规划，优化状态转移

    public int rob(int[] nums) {

        int n = nums.length;
        if(n == 0)
            return 0;

        // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] memo = new int[nums.length];
        memo[n - 1] = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i --)
            // 或者当前房子放弃, 从下一个房子开始考虑
            // 或者抢劫当前的房子, 从i+2以后的房子开始考虑
            memo[i] = Math.max(memo[i + 1],
                    nums[i] + (i + 2 < n ? memo[i + 2] : 0));

        return memo[0];
    }
}
