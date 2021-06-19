package _leetcode._DP._140;

import java.util.*;

/**
 * @Description: 单词拆分II
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * @Author: matreeix
 * @Date: 2020/7/1
 */

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        return word_Break(s, wordSet, 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) return map.get(start);

        List<String> res = new LinkedList<>();
        if (start == s.length()) res.add("");

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list)
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
            }
        }
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDicts = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = Arrays.asList(wordDicts);
        System.out.println((new Solution()).wordBreak(s,wordDict));
    }
}
