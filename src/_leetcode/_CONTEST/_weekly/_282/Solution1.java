package _leetcode._CONTEST._weekly._282;

/**
 * @Description: 6008. 统计包含给定前缀的字符串
 * 给你一个字符串数组 words 和一个字符串 pref 。
 * 返回 words 中以 pref 作为 前缀 的字符串的数目。
 * 字符串 s 的 前缀 就是  s 的任一前导连续字符串。
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length, pref.length <= 100
 * words[i] 和 pref 由小写英文字母组成
 * @Date: 2022/2/27
 */

public class Solution1 {
    public int prefixCount(String[] words, String pref) {
        int res = 0, n = pref.length();
        for (String word : words) {
            if (word.length() >= n) {
                res += word.substring(0, n).equals(pref) ? 1 : 0;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println("asdf".substring(0,4));
    }
}
