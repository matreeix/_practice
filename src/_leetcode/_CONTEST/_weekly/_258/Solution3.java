package _leetcode._CONTEST._weekly._258;

/**
 * @Description: 5869. 两个回文子序列长度的最大乘积
 * 给你一个字符串 s ，请你找到 s 中两个 不相交回文子序列 ，使得它们长度的 乘积最大 。两个子序列在原字符串中如果没有任何相同下标的字符，则它们是 不相交 的。
 * 请你返回两个回文子序列长度可以达到的 最大乘积 。
 * 子序列 指的是从原字符串中删除若干个字符（可以一个也不删除）后，剩余字符不改变顺序而得到的结果。如果一个字符串从前往后读和从后往前读一模一样，那么这个字符串是一个 回文字符串 。
 * 提示：
 * <p>
 * 2 <= s.length <= 12
 * s 只含有小写英文字母。
 * @Date: 2021/9/12
 */

public class Solution3 {

    // 位图法
    public int maxProduct(String s) {
        int[] dp = new int[4096];
        int res = 0, mask = (1 << s.length()) - 1;
        for (int m = 1; m <= mask; ++m)
            dp[m] = palSize(s, m);
        for (int m1 = mask; m1 > 0; --m1)
            if (dp[m1] * (s.length() - dp[m1]) > res)
                for (int m2 = mask ^ m1; m2 > 0; m2 = (m2 - 1) & (mask ^ m1))
                    res = Math.max(res, dp[m1] * dp[m2]);
        return res;
    }

    private int palSize(String s, int mask) {
        int p1 = 0, p2 = s.length(), res = 0;
        while (p1 <= p2) {
            if ((mask & (1 << p1)) == 0)
                ++p1;
            else if ((mask & (1 << p2)) == 0)
                --p2;
            else if (s.charAt(p1) != s.charAt(p2))
                return 0;
            else
                res += 1 + (p1++ != p2-- ? 1 : 0);
        }
        return res;
    }


    // 回溯法
    int max = 0;

    public int maxProduct2(String s) {
        char[] c = s.toCharArray();
        dfs(c, 0, "", "");
        return max;
    }

    public void dfs(char[] c, int idx, String s1, String s2) {
        if (idx >= c.length) {
            if (isPalin(s1) && isPalin(s2)) max = Math.max(max, s1.length() * s2.length());
            return;
        }
        dfs(c, idx + 1, s1 + c[idx], s2);// s1使用字符
        dfs(c, idx + 1, s1, s2 + c[idx]);// s2使用字符
        dfs(c, idx + 1, s1, s2);            // s1、s2均不使用字符
    }

    public boolean isPalin(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
