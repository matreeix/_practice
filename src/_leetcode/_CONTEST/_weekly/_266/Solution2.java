package _leetcode._CONTEST._weekly._266;

import java.util.Arrays;

/**
 * @Description: 5919. 所有子字符串中的元音
 * 给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
 * 子字符串 是字符串中一个连续（非空）的字符序列。
 * 注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
 * 提示：
 * 1 <= word.length <= 10^5
 * word 由小写英文字母组成
 * @Date: 2021/11/7
 */

public class Solution2 {
    public long countVowels(String word) {
        int[] pre = new int[word.length()];
        pre[0] = isVowel(word.charAt(0)) ? 1 : 0;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = isVowel(word.charAt(i)) ? pre[i - 1] + 1 : pre[i - 1];
        }
        long[] preSum = new long[word.length()];
        preSum[0] = pre[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + pre[i];
        }
        long[] dp = new long[word.length()];
        dp[0] = pre[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + (long) (i + 1) * pre[i] - preSum[i - 1];
        }
        return dp[word.length() - 1];
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.countVowels("aba"));
    }
}
