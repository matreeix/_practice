package _leetcode._CONTEST._biweekly._69;

import java.util.Arrays;

/**
 * @Description: 5962. 连接两字母单词得到的最长回文串
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 * 提示：
 * 1 <= words.length <= 10^5
 * words[i].length == 2
 * words[i] 仅包含小写英文字母。
 * @Date: 2022/1/8
 */

public class Solution3 {
    public int longestPalindrome(String[] words) {
        int[][] cnt = new int[26][26];
        for (String word : words) {
            char ch1 = word.charAt(0);
            char ch2 = word.charAt(1);
            cnt[ch1 - 'a'][ch2 - 'a']++;
        }
        int chDiff = 0, chSame = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = i + 1; j < cnt.length; j++) {
                chDiff += Math.min(cnt[i][j], cnt[j][i]) * 4;
            }
        }
        boolean simple = false;
        for (int i = 0; i < cnt.length; i++) {
            if (!simple && cnt[i][i] % 2 == 1) simple = true;
            chSame += 4 * (cnt[i][i] / 2);
        }
        chSame += simple ? 2 : 0;
        return chDiff + chSame;
    }

    public static void main(String[] args) {
        String[] strings = {"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
