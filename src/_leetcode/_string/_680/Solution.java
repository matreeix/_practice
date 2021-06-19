package _leetcode._string._680;

/**
 * @Description: 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Date: 2021/3/28
 */

public class Solution {

    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r))
                return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int a = -1, b = 1;
    }

}
