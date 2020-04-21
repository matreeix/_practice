package _DP._647;

/**
 * @Description: 统计回文子串个数
 * @Author: 67ng
 * @Date: 2020/4/20
 */
public class Solution {

    //使用动态规划
    public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int sum = 0;//s里回文子串的个数
        int n = s.length();//字符串长度
        sum += n;//对角线上的先加上
        boolean[][] count_palindrome = new boolean[n][n];//从下标0处开始使用
        for (int i = 0; i < n; i++) count_palindrome[i][i] = true;

        //填表方向与矩阵连乘积问题相同，只是针对每一个当前问题，用到的已解决子问题的位置不同
        for (int r = 2; r <= n; r++) {//待检查字符串长度
            for (int i = 0; i < n - r + 1; i++) {
                int j = i + r - 1;
                if (r == 2) {//俩字符
                    if (s.charAt(i) == s.charAt(j)) {
                        count_palindrome[i][j] = true;
                        sum += 1;
                    } else count_palindrome[i][j] = false;
                } else {//r>=3
                    count_palindrome[i][j] = count_palindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));//状态转移方程
                    if (count_palindrome[i][j]) sum += 1;
                }

            }

        }
        return sum;
    }

    //马拉车算法
    public int countSubstrings2(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z)
            ans += (v + 1) / 2;
        return ans;
    }
}
