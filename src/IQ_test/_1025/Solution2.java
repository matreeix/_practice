package IQ_test._1025;

/**
 * @Description: 使用动态规划解决
 * @Author: 67ng
 * @Date: 2020/2/24
 */
public class Solution2 {

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        for (int i = 2; i <= N; i++)
            for (int j = 1; j * j <= i; j++)//j中寻找i的因子
                if (i % j == 0 && !dp[i - j])
                    dp[i] = true;

        return dp[N];
    }

}
