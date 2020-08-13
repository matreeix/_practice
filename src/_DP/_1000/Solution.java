package _DP._1000;

/**
 * @Description: 1000. 合并石头的最低成本
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1
 * @Author: matreeix
 * @Date: 2020/8/11
 */

public class Solution {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) > 0) return -1;

        int[] prefix = new int[n + 1];//前缀和
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stones[i];

        int[][] dp = new int[n][n];//dp[i][j] 表示合并stones[i] ~ stones[j]的最小花销
        for (int len = K; len <= n; ++len)
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;//j-i == m-1
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);//找花销最小的两个区间进行合并
                if ((j - i) % (K - 1) == 0)//刚好能合并的情况
                    dp[i][j] += prefix[j + 1] - prefix[i];//[i,j]最后一轮合并的花销
            }
        return dp[0][n - 1];
    }

    //k=2的特例
    public int mergeStonesTwo(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int len = stones.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[len + 1][len + 1];
        int[] prefixSum = new int[len + 1];
        int i, j, k, l;
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        for (i = 1; i <= len; i++) {
            dp[i][i] = 0;
        }

        for (l = 2; l <= len; l++) {
            for (i = 1; i <= len - l + 1; i++) {
                j = i + l - 1;
                dp[i][j] = max;
                int sum = prefixSum[j] - prefixSum[i - 1];
                for (k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }

        return dp[1][len];
    }

}
