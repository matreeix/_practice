package _leetcode._CONTEST._weekly._211;

import java.util.Arrays;

/**
 * @Description: 5545. 无矛盾的最佳球队
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 * @Author: matreeix
 * @Date: 2020/10/18
 */

public class Solution3 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] candidate = new int[n][2];

        for (int i = 0; i < n; i++) {
            candidate[i][0] = ages[i];
            candidate[i][1] = scores[i];
        }
        Arrays.sort(candidate, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        dp[0] = candidate[0][1];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = candidate[i][1];
            for (int j = 0; j < i; j++) {
                if (candidate[j][1] <= candidate[i][1]) {
                    dp[i] = Math.max(dp[i], candidate[i][1] + dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
