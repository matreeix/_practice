package _leetcode._CONTEST._weekly._258;

/**
 * @Description: 5867. 反转单词前缀
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。
 * 如果 word 中不存在字符 ch ，则无需进行任何操作。
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
 * 返回 结果字符串 。
 * @Date: 2021/9/12
 */

public class Solution1 {
    public String reversePrefix(String word, char ch) {
        int end = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                end = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = end; i > -1; i--) {
            sb.append(word.charAt(i));
        }
        sb.append(word.substring(end + 1));
        return sb.toString();
    }

}
