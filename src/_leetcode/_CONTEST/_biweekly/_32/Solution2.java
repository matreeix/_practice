package _leetcode._CONTEST._biweekly._32;

/**
 * @Description: 5469. K 次操作转变字符串
 * 给你两个字符串 s 和 t ，你的目标是在 k 次操作以内把字符串 s 转变成 t 。
 * <p>
 * 在第 i 次操作时（1 <= i <= k），你可以选择进行如下操作：
 * <p>
 * 选择字符串 s 中满足 1 <= j <= s.length 且之前未被选过的任意下标 j （下标从 1 开始），并将此位置的字符切换 i 次。
 * 不进行任何操作。
 * 切换 1 次字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 'z' 切换后会变成 'a'）。
 * <p>
 * 请记住任意一个下标 j 最多只能被操作 1 次。
 * <p>
 * 如果在不超过 k 次操作内可以把字符串 s 转变成 t ，那么请你返回 true ，否则请你返回 false 。
 * @Author: matreeix
 * @Date: 2020/8/8
 */

public class Solution2 {
    public static boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (tt[i] != ss[i]) {
                int min = tt[i] > ss[i] ? tt[i] - ss[i] : 26 - ss[i] + tt[i];
                if (26 * cnt[min - 1] + min > k)
                    return false;
                else
                    cnt[min - 1]++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canConvertString("input", "ouput", 9));
        System.out.println(canConvertString("abc", "bcd", 10));
        System.out.println(canConvertString("aab", "bbb", 27));
    }
}
