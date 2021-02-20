package _greedy._1754;

/**
 * @Description: 1754. 构造字典序最大的合并字符串
 * 给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，只能选择 其一 继续操作：
 * 如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
 * 例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva"
 * 返回你可以构造的字典序 最大 的合并字符串 merge 。
 * @Date: 2021/2/20
 */

public class Solution {
    public String largestMerge(String word1, String word2) {
        if (word1.length() == 0  || word2.length() == 0)
            return word1 + word2;
        if (word1.compareTo(word2) > 0)
            return word1.charAt(0) + largestMerge(word1.substring(1), word2);
        return word2.charAt(0) + largestMerge(word1, word2.substring(1));
    }
}
