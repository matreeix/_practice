package _leetcode._CONTEST._biweekly._68;

/**
 * @Description: 5946. 句子中的最多单词数
 * 一个 句子 由一些 单词 以及它们之间的单个空格组成，句子的开头和结尾不会有多余空格。
 * 给你一个字符串数组 sentences ，其中 sentences[i] 表示单个 句子 。
 * 请你返回单个句子里 单词的最多数目 。
 * @Date: 2021/12/25
 */

public class Solution1 {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String s : sentences) {
            String[] strings = s.split(" ");
            res = Math.max(res, strings.length);
        }
        return res;
    }
}
