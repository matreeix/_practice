package _leetcode._CONTEST._biweekly._58;

/**
 * @Description: 5193. 删除字符使字符串变好
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 只包含小写英文字母。
 * @Date: 2021/8/7
 */

public class Solution1 {

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char pre = '0';
        for (char ch : s.toCharArray()) {
            if (pre == ch) {
                cnt++;
            } else {
                cnt = 1;
                pre = ch;
            }
            if (cnt < 3) sb.append(ch);
        }
        return sb.toString();
    }
}