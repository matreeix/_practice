package _DP._1770;

import java.util.Arrays;

/**
 * @Description: 1770. 执行乘法运算的最大分数
 * 给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
 * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
 * <p>
 * 1.选择数组 nums 开头处或者末尾处 的整数 x 。
 * 2.你获得 multipliers[i] * x 分，并累加到你的分数中。
 * 3.将 x 从数组 nums 中移除。
 * 在执行 m 步操作后，返回 最大 分数。
 *
 * 提示：
 *
 * n == nums.length
 * m == multipliers.length
 * 1 <= m <= 103
 * m <= n <= 105
 * -1000 <= nums[i], multipliers[i] <= 1000
 *
 *
 * @Date: 2021/2/26
 */

public class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m+1][m+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        for (int i = 0; i <= m; i++) {
            dp[i][m-i] = 0;
        }
        for (int k = m-1; k >= 0; k--) {
            for (int l = 0; l <= k; l++) {
                int r = k-l;
                dp[l][r] = Math.max(
                        dp[l+1][r] + nums[l] * multipliers[k],
                        dp[l][r+1] + nums[n-r-1] * multipliers[k]
                );
            }
        }
        return dp[0][0];
    }
}
