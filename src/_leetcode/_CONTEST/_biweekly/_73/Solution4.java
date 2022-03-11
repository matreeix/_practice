package _leetcode._CONTEST._biweekly._73;

/**
 * @Description: 2193. 得到回文串的最少操作次数
 * 给你一个只包含小写英文字母的字符串 s 。
 * 每一次 操作 ，你可以选择 s 中两个 相邻 的字符，并将它们交换。
 * 请你返回将 s 变成回文串的 最少操作次数 。
 * 注意 ，输入数据会确保 s 一定能变成一个回文串。
 * 提示：
 * 1 <= s.length <= 2000
 * s 只包含小写英文字母。
 * s 可以通过有限次操作得到一个回文串。
 * @Date: 2022/3/11
 */

public class Solution4 {
    public int minMovesToMakePalindrome(String s) {
        if (s.length() == 0) return 0;
        int cnt = 0, n = s.length();
        StringBuilder temp = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(0) && i != 0) {
                for (int j = 1; j < i; j++) temp.append(s.charAt(j));
                for (int j = i + 1; j < n; j++) temp.append(s.charAt(j));
                cnt += n - i - 1;
                break;
            }
            if (i == 0) {
                cnt += n / 2;
                temp = new StringBuilder(s.substring(1));
            }
        }
        return cnt + minMovesToMakePalindrome(temp.toString());
    }
}