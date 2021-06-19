package _leetcode._CONTEST._weekly._219;

/**
 * @Description: 5627. 石子游戏 VII
 * 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
 * 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
 * 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
 * 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
 * @Author: matreeix
 * @Date: 2020/12/13
 */

public class Solution3 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j)
                    dp[i][j] = stones[i]; //记录区间和
                else
                    dp[i][j] = stones[j] + dp[i][j - 1];
            }
        }
        int[][] res = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - i == 1)
                    res[i][j] = Math.max(stones[i], stones[j]);
                else
                    res[i][j] = Math.max(dp[i + 1][j] - res[i + 1][j], dp[i][j - 1] - res[i][j - 1]);
            }
        }
        return res[0][n - 1]; //返回A能取的最大和
    }
}
