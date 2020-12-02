package _CONTEST._biweekly._38;

/**
 * @Description: 1638. 统计只差一个字符的子串数目
 * 给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 恰好 只有一个字符不同的子字符串对的数目。
 * <p>
 * 比方说， "computer" 和 "computation" 加粗部分只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。
 * <p>
 * 请你返回满足上述条件的不同子字符串对数目。
 * <p>
 * 一个 子字符串 是一个字符串中连续的字符。
 * @Author: matreeix
 * @Date: 2020/11/3
 */

public class Solution3 {
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int diff = 0;
                for (int k = 0; i + k < m && j + k < n; ++k) {
                    diff += (s.charAt(i + k) != t.charAt(j + k)) ? 1 : 0;
                    if (diff > 1) break;
                    if (diff == 1) ++ans;
                }
            }
        }
        return ans;

    }
}
