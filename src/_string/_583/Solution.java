package _string._583;

/**
 * @Description: 两个字符串删除字符
 * @Author: caffebaby
 * @Date: 2020/5/22
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;

        int[][] dp = new int[m + 1][n + 1];//dp[i][j]表示索引分别为i、j的s1和s2的LCS长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "seea";
        String s2 = "eoat";

        System.out.println((new Solution()).minDistance(s1, s2));
    }
}
