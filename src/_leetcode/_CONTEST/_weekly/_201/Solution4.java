package _leetcode._CONTEST._weekly._201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 切棍子的最小成本
 * <p>
 * 有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
 * 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
 * 你可以按顺序完成切割，也可以根据需要更改切割的顺序。
 * 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。
 * 对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。请参阅第一个示例以获得更直观的解释。
 * <p>
 * 返回切棍子的 最小总成本 。
 * @Author: matreeix
 * @Date: 2020/8/9
 */

public class Solution4 {
    //精简写法
    public int minCost(int n, int[] cuts) {
        List<Integer> A = new ArrayList<>();
        for (int a : cuts) {
            A.add(a);
        }
        A.add(0);
        A.add(n);
        Collections.sort(A);
        int k = A.size();
        int[][] dp = new int[k][k];
        for (int j = 2; j < k; ++j) {
            for (int i = 0; i < k - j; ++i) {
                dp[i][i + j] = 1000000000;
                for (int m = i + 1; m < i + j; ++m) {
                    dp[i][i + j] = Math.min(dp[i][i + j], dp[i][m] + dp[m][i + j] + A.get(i + j) - A.get(i));
                }
            }
        }
        return dp[0][k - 1];
    }

    //参考1000题的修改
    public int minCost2(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] stones = new int[cuts.length + 1];
        stones[0] = cuts[0];
        stones[cuts.length] = n - cuts[cuts.length - 1];
        for (int i = 1; i < stones.length; i++) {
            stones[i] = cuts[i] - cuts[i - 1];
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
