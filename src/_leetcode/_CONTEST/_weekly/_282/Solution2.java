package _leetcode._CONTEST._weekly._282;

/**
 * @Description: 6009. 使两字符串互为字母异位词的最少步骤数
 * 给你两个字符串 s 和 t 。在一步操作中，你可以给 s 或者 t 追加 任一字符 。
 * 返回使 s 和 t 互为 字母异位词 所需的最少步骤数。
 * 字母异位词 指字母相同但是顺序不同（或者相同）的字符串。
 * 提示：
 * 1 <= s.length, t.length <= 2 * 10^5
 * s 和 t 由小写英文字符组成
 * @Date: 2022/2/27
 */

public class Solution2 {
    public int minSteps(String s, String t) {
        int[] cntS = new int[26];
        int[] cntT = new int[26];
        for (char ch : s.toCharArray()) cntS[ch - 'a']++;
        for (char ch : t.toCharArray()) cntT[ch - 'a']++;
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(cntS[i] - cntT[i]);
        }
        return res;
    }
}
