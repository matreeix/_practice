package _CONTEST._weekly._185;

import java.util.Arrays;

/**
 * @Description: 1420. 生成数组
 * 给你三个整数 n、m 和 k 。从函数getMax(int[] arr)描述的方法中找出正整数数组中最大的元素。
 * 请你生成一个具有下述属性的数组 arr ：
 * <p>
 * 1.arr 中有 n 个整数。
 * 2.1 <= arr[i] <= m 其中 (0 <= i < n) 。
 * 3.将上面提到的算法应用于 arr ，search_cost 的值等于 k 。
 * <p>
 * 返回上述条件下生成数组 arr 的 个数 ，由于答案可能会很大，所以必须对 10^9 + 7 取余。
 * <p>
 * 提示：
 * 1 <= n <= 50
 * 1 <= m <= 100
 * 0 <= k <= n
 * @Author: matreeix
 * @Date: 2020/7/22
 */

public class Solution4 {

    //DP
    public int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
        return dfs(n, m, k, 0, 0, 0, dp);
    }

    // dfs(... i, currMax, currCost) the number of ways to build the valid array `arr[i:]`
    // keeping in mind that current maximum element is `currMax` and current search cost is `currCost`
    private int dfs(int n, int m, int k, int i, int currMax, int currCost, Integer[][][] dp) {
        if (i == n) {
            if (k == currCost) return 1; // valid if the value search cost is equal to k
            return 0;
        }
        if (dp[i][currMax][currCost] != null)
            return dp[i][currMax][currCost];
        int ans = 0;
        // Case 1: num in range [1, currMax], newMax = currMax, newCost = currCost
        ans += (long) currMax * dfs(n, m, k, i + 1, currMax, currCost, dp) % 1_000_000_007;
        // Case 2: num in range [currMax+1, m], newMax = num, newCost = currCost + 1
        if (currCost + 1 <= k) {
            for (int num = currMax + 1; num <= m; num++) {
                ans += dfs(n, m, k, i + 1, num, currCost + 1, dp);
                ans %= 1_000_000_007;
            }
        }
        return dp[i][currMax][currCost] = ans;
    }

    //较优解法
    public int numOfArrays2(int n, int m, int k) {
        if (k > m) return 0;

        long[][] dp = new long[k + 1][m];
        Arrays.fill(dp[1], 1);
        long mod = 1000000007;
        for (int i = 1; i < n; i++) {
            long[][] next = new long[k + 1][m];
            for (int j = 1; j <= Math.min(k, i + 1); j++) {
                long sum = 0;
                for (int l = 0; l < m; l++) {
                    next[j][l] += sum;
                    next[j][l] %= mod;
                    sum += dp[j - 1][l];
                    sum %= mod;
                    next[j][l] += dp[j][l] * (l + 1);
                    next[j][l] %= mod;
                }
            }
            dp = next;
        }
        long res = 0;
        for (long num : dp[k]) {
            res += num;
            res %= mod;
        }
        return (int) res;
    }

    private int getMax(int[] arr) {
        int max_value = -1, max_index = -1;
        int search_cost = 0;//从索引0开始到找到最大值增大的次数
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (max_value < arr[i]) {
                max_value = arr[i];
                max_index = i;
                search_cost++;
            }
        }
        return max_index;
    }

    public static void main(String[] args) {

    }
}