package _CONTEST._weekly._214;

import java.util.Arrays;

/**
 * @Description: 5562. 字符频次唯一的最小删除次数
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * <p>
 * 提示：
 * 1 <= s.length <= 10 ^ 5
 * s 仅含小写英文字母
 * @Author: matreeix
 * @Date: 2020/11/8
 */

public class Solution2 {
    public int minDeletions(String s) {
        int[] cnt = new int[26];//Count character frequency
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        Arrays.sort(cnt);
        int res = 0;
        for (int i = 25; i > 0; i--) {//Greedy from back to front
            if (cnt[i] <= cnt[i - 1]) {
                res += cnt[i] == 0 ? cnt[i - 1] : cnt[i - 1] - cnt[i] + 1;
                cnt[i - 1] = Math.max(cnt[i] - 1, 0);//You can only be greedy to 0
            }
        }
        return res;
    }
}
