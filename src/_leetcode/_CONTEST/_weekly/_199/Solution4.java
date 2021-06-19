package _leetcode._CONTEST._weekly._199;

import java.util.*;

/**
 * @Description: 5462. 压缩字符串 II
 * 行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符
 * （重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。
 * 例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。
 * 因此压缩后的字符串变为 "a2bc3" 。
 * 注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
 * 给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
 * 请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
 * @Author: matreeix
 * @Date: 2020/7/26
 */

public class Solution4 {

    //较优的解法
    public static int getLengthOfOptimalCompression(String s, int k) {
        int len = s.length();
        int[][] dp = new int[len + 1][k + 2];//在[0，i-1]区间中，删除k个字符，得到的答案
        for (int i = 1; i <= len; i++) //dp[0][i] = 0
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        char[] sArr = s.toCharArray();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i - 1][j]);//删除第i-1个字符
                int cnt = 0;//统计相同字符i的个数
                int del = 0;//删除字符的个数
                for (int l = i; l <= len; l++) {//不删除第i-1个字符
                    if (sArr[l - 1] == sArr[i - 1])
                        cnt++;
                    else
                        del++; //试图删除后面的所有的字符
                    if (j + del <= k)//约束条件
                        dp[l][j + del] = Math.min(dp[l][j + del],
                                dp[i - 1][j] + 1 + (cnt >= 100 ? 3 : (cnt >= 10 ? 2 : (cnt >= 2 ? 1 : 0))));
//                     System.out.println(i+" "+j+" "+dp[i-1][j]);
                }
            }
        }
        return dp[len][k];
    }

    Integer[][][][] dp;
    Set<Integer> add = new HashSet<Integer>(){{add(1);add(9);add(99);}};

    public int getLengthOfOptimalCompression2(String s, int k) {
        int len = s.length();
        dp = new Integer[len + 1][27][len + 1][k + 1];
        return dfs(s, 0, (char) ('a' + 26), 0, k);
    }

    // idx, current index, p, previous char, cnt, previous char count, k, num of char removable
    private int dfs(String s, int idx, char p, int cnt, int k) {
        if (k < 0)
            return Integer.MAX_VALUE;
        if (idx >= s.length())
            return 0;
        if (dp[idx][p - 'a'][cnt][k] != null)
            return dp[idx][p - 'a'][cnt][k];
        int res = 0;
        if (s.charAt(idx) == p)
            res = dfs(s, idx + 1, p, cnt + 1, k) + (add.contains(cnt) ? 1 : 0);
        else
            res = Math.min(dfs(s, idx + 1, s.charAt(idx), 1, k) + 1, dfs(s, idx + 1, p, cnt, k - 1));
        dp[idx][p - 'a'][cnt][k] = res;
        return res;
    }

    public static void main(String[] args) {
        String s = "aaabcccd";
        System.out.println(getLengthOfOptimalCompression(s, 2));
    }
}
