package _leetcode._hashtable._567;

/**
 * @Description: 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * @Date: 2021/7/9
 */

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        int[] cnt = new int[26];
        for (char ch : s1.toCharArray()) cnt[ch - 'a']++;
        int[] tmp = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            if (i < len1) {
                tmp[s2.charAt(i) - 'a']++;
            } else {
                if (check(cnt, tmp)) return true;
                tmp[s2.charAt(i) - 'a']++;
                tmp[s2.charAt(i - len1) - 'a']--;
            }
        }
        return check(cnt, tmp);
    }

    private boolean check(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
