package _hashtable._395;

/**
 * @Description: 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * @Created by: matreeix
 * @Date: 2021/5/20
 */
public class Solution {
    public static int longestSubstring(String s, int k) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;
        int start = -1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, i - start - 1);
                start = i;
                System.out.println(res);
            }
        }
        res = Math.max(res, s.length() - start-1);
        return res;
    }

    public static void main(String[] args) {
        String s1 = "aaaaqazaaxbbbnbbccmccccclddddddpdeeeeeeyffffffff";
        String s2 = "aaabb";
        String s3 = "qazaaxbbbnbbccmccccclddddddpdeeeeeeyffffffff";
        System.out.println(longestSubstring(s1, 3));
    }
}
