package _hashtable._409;

import java.util.Arrays;

/**
 * @Description: 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * @Author: matreeix
 * @Date: 2020/9/21
 */

public class Solution {
    public static int longestPalindrome(String s) {
        int[] cnt = new int[52];
        for (char ch : s.toCharArray())
            if (ch > 96)
                cnt[ch - 'a']++;
            else
                cnt[ch - 'A' + 26]++;
        System.out.println(Arrays.toString(cnt));
        int res = 0, tmp = 0;
        for (int i : cnt)
            if (i % 2 == 0)
                res += i;
            else
                tmp = Math.max(tmp, i);
        return res + tmp;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("asdzxcqwerfvbASDgtyhnmjuiklopQWERTYUIOPASDCXZFVGBHNJMKL"));
        System.out.println('A' + 0);
    }
}
