package _DP._375;

import java.util.Arrays;

/**
 * @Description: 猜中数字付出的最小代价
 * @Author: caffebaby
 * @Date: 2020/3/18
 */

//dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }
public class Solution {
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];//为了取到边界1、n
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {//猜k
                        dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
    }

}
