package _leetcode._CONTEST._weekly._211;

/**
 * @Description: 5543. 两个相同字符之间的最长子字符串
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * @Author: matreeix
 * @Date: 2020/10/18
 */

public class Solution1 {
    public static int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    res = Math.max(j - i - 1, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aa"));
        System.out.println(maxLengthBetweenEqualCharacters("abba"));
        System.out.println(maxLengthBetweenEqualCharacters("abcd"));
        System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
    }
}
