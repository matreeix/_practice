package _leetcode._DP._139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * 1.拆分时可以重复使用字典中的单词。
 * 2.你可以假设字典中没有重复的单词。
 * @Author: matreeix
 * @Date: 2020/7/1
 */

public class Solution {

    //dp
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];//dp[i] 表示字符串 s 前 i 个字符组成的字符串s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //dp优化，剪枝
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0) return false;

        HashSet<String> wordSet = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = 0;
        for (String w : wordDict) {//将所有字典词存入哈希表，并找到最长和最短的长度
            wordSet.add(w);
            minLen = Math.min(minLen, w.length());
            maxLen = Math.max(maxLen, w.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = minLen; i <= s.length(); i++) {
            dp[i] = wordSet.contains(s.substring(0, i));//找到第一个存在的词
            if (!dp[i] && i + 1 >= 2 * minLen) {//剪枝，从第二个词开始找
                for (int j = minLen; j < i; j++) {
                    if (i - j < minLen || j > maxLen) break;//过长或者过短进行剪枝
                    if (dp[i]) break;//已经出现的直接剪枝
                    dp[i] = dp[i - j] && wordSet.contains(s.substring(i - j, i));//状态转移
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s1 = "catsandog";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("cats");
        wordDict1.add("dog");
        wordDict1.add("sand");
        wordDict1.add("and");
        wordDict1.add("cat");

        String s2 = "leetcode";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("leet");
        wordDict2.add("code");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s1, wordDict1));
        System.out.println(solution.wordBreak(s2, wordDict2));
        System.out.println("qwe".substring(0, 1));
    }
}