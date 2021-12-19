package _leetcode._CONTEST._weekly._272;

/**
 * @Description: 5956. 找出数组中的第一个回文字符串
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 仅由小写英文字母组成
 * @Date: 2021/12/19
 */

public class Solution1 {
    public String firstPalindrome(String[] words) {
        for (String word : words)
            if (check(word))
                return word;
        return "";
    }

    private boolean check(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        return true;
    }
}
