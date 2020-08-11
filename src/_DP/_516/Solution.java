package _DP._516;

/**
 * @Description: 最长回文子序列
 * @Author: caffebaby
 * @Date: 2020/4/17
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];//f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
        for (int i = n - 1; i >= 0; i--) {//注意，遍历顺序要确保所有子问题都已经求解过
            f[i][i] = 1;//base case
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;//状态转移方程1
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);//状态转移方程2
                }
            }
        }
        return f[0][n - 1];
    }
}
