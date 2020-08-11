package _greedy._1326;

import java.util.Arrays;

/**
 * @Description: 灌溉花园的最少水龙头数目
 * <p>
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 * 请你返回可以灌溉整个花园的最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 * @Author: caffebaby
 * @Date: 2020/7/9
 */

public class Solution {
    //dp
    public int minTaps2(int n, int[] A) {
        int[] dp = new int[n + 1];//dp[i] 表示浇灌[0,i]的最少水龙头数目
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for (int i = 0; i <= n; ++i)
            for (int j = Math.max(i - A[i] + 1, 0); j <= Math.min(i + A[i], n); ++j)
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - A[i])] + 1);
        return dp[n] < n + 2 ? dp[n] : -1;
    }

    //排序后再贪心
    public int minTaps3(int n, int[] ranges) {
        int[][] districts = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            districts[i][0] = i - ranges[i];
            districts[i][1] = i + ranges[i];
        }

        int res = 0;
        Arrays.sort(districts, (a, b) -> a[0] - b[0]);
        for (int i = 0, left = 0, right = 0; left < n; left = right, ++res) {
            for (; i < districts.length && districts[i][0] <= left; ++i)
                right = Math.max(right, districts[i][1]);
            if (left == right)
                return -1;
        }
        return res;
    }

    //时间性能较好,不用排序的贪心
    public int minTaps(int n, int[] ranges) {
        int[] reach = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            reach[left] = i + ranges[i];
        }

        int canReach = 0, next = 0, count = 0;
        for (int i = 0; i <= n; i++) {
            if (i > next) {
                return -1;
            }
            if (i > canReach) {
                canReach = next;
                count += 1;
            }
            next = Math.max(next, reach[i]);
        }
        return count;
    }
}