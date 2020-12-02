package _CONTEST._biweekly._38;

/**
 * @Description: 1639. 通过给定词典构造目标字符串的方案数
 * 给你一个字符串列表 words 和一个目标字符串 target 。words 中所有字符串都 长度相同  。
 * 你的目标是使用给定的 words 字符串列表按照下述规则构造 target ：
 * 从左到右依次构造 target 的每一个字符。
 * 为了得到 target 第 i 个字符（下标从 0 开始），当 target[i] = words[j][k] 时，你可以使用 words 列表中第 j 个字符串的第 k 个字符。
 * 一旦你使用了 words 中第 j 个字符串的第 k 个字符，你不能再使用 words 字符串列表中任意单词的第 x 个字符（x <= k）。也就是说，所有单词下标小于等于 k 的字符都不能再被使用。
 * 请你重复此过程直到得到目标字符串 target 。
 * 请注意， 在构造目标字符串的过程中，你可以按照上述规定使用 words 列表中 同一个字符串 的 多个字符 。
 * 请你返回使用 words 构造 target 的方案数。由于答案可能会很大，请对 109 + 7 取余 后返回。
 *
 * （译者注：此题目求的是有多少个不同的 k 序列，详情请见示例。）
 * @Author: matreeix
 * @Date: 2020/11/3
 */

public class Solution4 {
    String[] words;
    String target;
    Integer[][] memo;
    int m, n;
    int[][] charAtIndexCnt;
    public int numWays(String[] words, String target) {
        this.words = words; this.target = target;
        m = words[0].length(); n = target.length();
        memo = new Integer[m][n];
        charAtIndexCnt = new int[128][m];

        for (String word : words)
            for (int i = 0; i < word.length(); i++)
                charAtIndexCnt[word.charAt(i)][i] += 1; // Count the number of character `c` at index `i` of all words
        return dp(0, 0);
    }

    int dp(int k, int i) {
        if (i == n)  // Formed a valid target
            return 1;
        if (k == m)  // Reached to length of words[x] but don't found any result
            return 0;
        if (memo[k][i] != null) return memo[k][i];
        char c = target.charAt(i);
        long ans = dp(k + 1, i);  // Skip k_th index of words
        if (charAtIndexCnt[c][k] > 0) { // Take k_th index of words if found character `c` at index k_th
            ans += (long) dp(k + 1, i + 1) * charAtIndexCnt[c][k];
            ans %= 1_000_000_007;
        }
        return memo[k][i] = (int) ans;
    }
}
