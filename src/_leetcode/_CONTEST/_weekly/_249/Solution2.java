package _leetcode._CONTEST._weekly._249;

import java.util.Arrays;

/**
 * @Description: 5809. 长度为 3 的不同回文子序列
 * 给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
 * 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
 * 回文 是正着读和反着读一样的字符串。
 * 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
 * 例如，"ace" 是 "abcde" 的一个子序列。
 * 提示：
 * 3 <= s.length <= 10^5
 * s 仅由小写英文字母组成
 * @Date: 2021/7/11
 */

public class Solution2 {

    public int countPalindromicSubsequence(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < cnt.length; i++) {
            int l = -1, r = -1;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) - 'a' == i) l = l == -1 ? j : l;
                if (s.charAt(j) - 'a' == i) r = Math.max(r, j);
            }
            int[] tmp = new int[26];
            for (int j = l + 1; j < r; j++) {
                tmp[s.charAt(j) - 'a']++;
            }
            for (int value : tmp)
                if (value != 0)
                    cnt[i]++;
        }
        int res = 0;
        for (int value : cnt) res += value;
        return res;
    }

    //同解法一
    public int countPalindromicSubsequence2(String s) {
        int first[] = new int[26], last[] = new int[26], res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ++i) {
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i)
            if (first[i] < last[i])
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
        return res;
    }

}
