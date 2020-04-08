package _DP._312;

/**
 * @description ：
 * @date ： 2020-04-08
 */
public class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return maxCoins(nums, 0, nums.length - 1, dp);
    }

    public int maxCoins(int[] nums, int start, int end, int[][] dp) {
        if (start > end)
            return 0;
        if (dp[start][end] != 0)//记忆化
            return dp[start][end];

        int max = nums[start];
        //核心是自底向上的记忆化
        for (int i = start; i <= end; i++) {
            int val = maxCoins(nums, start, i - 1, dp) +
                    get(nums, i) * get(nums, start - 1) * get(nums, end + 1) +
                    maxCoins(nums, i + 1, end, dp);//在区间[start,end]中最后扎i气球

            max = Math.max(max, val);
        }
        dp[start][end] = max;
        return max;
    }

    public int get(int[] nums, int i) {
        if (i == -1 || i == nums.length)
            return 1;
        return nums[i];
    }
}
