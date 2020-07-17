package _DP._877;

import java.util.Arrays;

/**
 * @Description: 石子游戏
 * <p>
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * @Author: Pythagodzilla
 * @Date: 2020/7/17
 */

public class Solution {

    /**
     * 如果亚历克斯想挑偶数索引piles[0], piles[2], ....., piles[n-2]，
     * 他会先挑piles[0]，然后李可以选择piles[1]或piles[n - 1]。
     * 每一回合，Alex总是可以选择偶数索引，而Lee只能选择奇数索引。
     * 所以，
     * 如果sum(piles[even]) > sum(piles[odd])，亚历克斯会选择所有偶数并赢得胜利。
     * 如果sum(piles[even]) < sum(piles[odd])，亚历克斯会选择所有的奇数索引赢得胜利。
     * 先手必赢。
     */
    public static boolean stoneGame(int[] piles) {
        return true;
    }

    /**
     * 如果piles.length可以是奇数怎么办？
     * 如果我们想确切知道分数的差异怎么办？
     */

    //二维dp
    public boolean stoneGame2(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }

    //一维dp
    public boolean stoneGame3(int[] p) {
        int[] dp = Arrays.copyOf(p, p.length);
        for (int d = 1; d < p.length; d++)
            for (int i = 0; i < p.length - d; i++)
                dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
        return dp[0] > 0;
    }


    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
    }
}