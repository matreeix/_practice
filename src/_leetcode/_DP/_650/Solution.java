package _leetcode._DP._650;

/**
 * @Description:
 *
 * 最初在记事本上只有一个字符"A"。您可以在此记事本上为每个步骤执行两项操作：
 * <p>
 * Copy All：您可以复制记事本上的所有字符（不允许部分复制）。
 * Paste：您可以粘贴上次复制的字符。
 * <p>
 * 给出一个数字n。您必须通过执行允许的最少步骤数。输出最小步数以获得n个"A"。
 *
 * @Author: matreeix
 * @Date: 2020/3/19
 */

//详细分析见:https://leetcode.com/problems/2-keys-keyboard/discuss/105932/Java-solutions-from-naive-DP-to-optimized-DP-to-non-DP
public class Solution {

    //DP
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break;
                }

            }
        }
        return dp[n];
    }

    //非DP
    // n1/i=n2,n2/j=n3,...nk/m=1,则res = i+j+....+m
    public int minSteps2(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n = n / i;
            }
        }
        return res;
    }
}
