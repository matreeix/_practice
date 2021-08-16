package _leetcode._CONTEST._weekly._254;

/**
 * @Description: 5843. 作为子字符串出现在单词中的字符串数目
 * 给你一个字符串数组 patterns 和一个字符串 word ，统计 patterns 中有多少个字符串是 word 的子字符串。返回字符串数目。
 * 子字符串 是字符串中的一个连续字符序列。
 * @Date: 2021/8/15
 */

public class Solution1 {

    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) {
                res++;
            }
        }
        return res;
    }

}
