package _leetcode._DP._1039;

/**
 * @description ：多边形的最大值
 * @date ： 2020-04-18
 */
public class Solution {
    //Bottom-Up
    public int minScoreTriangulation(int[] A) {
        int[][] dp = new int[50][50];
        for (int i = A.length - 1; i >= 0; --i)
            for (int j = i + 1; j < A.length; ++j)
                for (int k = i + 1; k < j; ++k)
                    dp[i][j] = Math.min(dp[i][j] == 0 ?
                            Integer.MAX_VALUE : dp[i][j], dp[i][k] + A[i] * A[k] * A[j] + dp[k][j]);
        return dp[0][A.length - 1];
    }

}
