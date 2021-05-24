package _hashtable._395;

/**
 * @Description: 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * @Created by: matreeix
 * @Date: 2021/5/20
 */
public class Solution {
    public static int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public static int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {//统计[l.r]间字符频数
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;//找出小于k的字符
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {//不存在 <k 的字符，直接返回
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s1 = "aaaaqazaaxbbbnbbccmccccclddddddpdeeeeeeyffffffff";
        String s2 = "aaabb";
        String s3 = "qazaaxbbbnbbccmccccclddddddpdeeeeeeyffffffff";
        System.out.println(longestSubstring(s1, 3));
    }
}
