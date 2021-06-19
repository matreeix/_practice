package _leetcode._CONTEST._weekly._203;

/**
 * @Description: 5498. 石子游戏 V
 * 几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。
 * 游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；Bob 负责计算每一行的值，即此行中所有石子的值的总和。
 * Bob 会丢弃值最大的行，Alice 的得分为剩下那行的值（每轮累加）。如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。
 * 只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。
 * 返回 Alice 能够获得的最大分数 。
 * @Author: matreeix
 * @Date: 2020/8/23
 */

public class Solution4 {

    //O(n^3)
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        prefix[0] = stoneValue[0];
        for (int i = 1; i <= n; i++) {
            prefix[i] = stoneValue[i - 1] + prefix[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int mid = i; mid < j; mid++) {
                    int left = prefix[mid + 1] - prefix[i];
                    int right = prefix[j + 1] - prefix[mid + 1];
                    if (left > right) {
                        dp[i][j] = Math.max(dp[i][j], dp[mid + 1][j] + right);
                    } else if (left < right) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][mid] + left);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[mid + 1][j] + right, dp[i][mid] + left));
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {

    }
}