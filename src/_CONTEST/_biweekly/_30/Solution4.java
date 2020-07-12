package _CONTEST._biweekly._30;

/**
 * @Description: 石头游戏IV
 * <p>
 * 爱丽丝和鲍勃轮流玩游戏，爱丽丝先开始。
 * 最初，n一堆石头。在每个玩家的回合上，该玩家进行一次移除，移除堆中任何非零平方数的石头。
 * 同样，如果玩家无法采取行动，他/她将输掉比赛。
 * 给定一个正整数n。返回  True 当且仅当爱丽丝赢得比赛，否则返回False，假设两个球员发挥最佳。
 * @Author: Pythagodzilla
 * @Date: 2020/7/12
 */

public class Solution4 {
    public static boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];//数字n时，alice是否胜利
        dp[1] = true;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(winnerSquareGame(1));//true
        System.out.println(winnerSquareGame(2));
        System.out.println(winnerSquareGame(7));
        System.out.println(winnerSquareGame(8));
        System.out.println(winnerSquareGame(9));
        System.out.println(winnerSquareGame(17));

    }
}
