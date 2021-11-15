package _leetcode._CONTEST._biweekly._65;

/**
 * @Description: 5910. 检查两个字符串是否几乎相等
 * 如果两个字符串 word1 和 word2 中从 'a' 到 'z' 每一个字母出现频率之差都 不超过 3 ，那么我们称这两个字符串 word1 和 word2 几乎相等 。
 * 给你两个长度都为 n 的字符串 word1 和 word2 ，如果 word1 和 word2 几乎相等 ，请你返回 true ，否则返回 false 。
 * 一个字母 x 的出现 频率 指的是它在字符串中出现的次数。
 * @Date: 2021/11/13
 */

public class Solution1 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] cnt = new int[26];
        for (char ch : word1.toCharArray()) {
            cnt[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            cnt[ch - 'a']--;
        }
        for (int i : cnt) {
            if (Math.abs(i) > 3) {
                return false;
            }
        }
        return true;
    }
}
