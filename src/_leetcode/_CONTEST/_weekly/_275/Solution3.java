package _leetcode._CONTEST._weekly._275;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 5978. 统计追加字母可以获得的单词数
 * 给你两个下标从 0 开始的字符串数组 startWords 和 targetWords 。每个字符串都仅由 小写英文字母 组成。
 * 对于 targetWords 中的每个字符串，检查是否能够从 startWords 中选出一个字符串，执行一次 转换操作 ，得到的结果与当前 targetWords 字符串相等。
 * 转换操作 如下面两步所述：
 * 追加 任何 不存在 于当前字符串的任一小写字母到当前字符串的末尾。
 * 例如，如果字符串为 "abc" ，那么字母 'd'、'e' 或 'y' 都可以加到该字符串末尾，但 'a' 就不行。如果追加的是 'd' ，那么结果字符串为 "abcd" 。
 * 重排 新字符串中的字母，可以按 任意 顺序重新排布字母。
 * 例如，"abcd" 可以重排为 "acbd"、"bacd"、"cbda"，以此类推。注意，它也可以重排为 "abcd" 自身。
 * 找出 targetWords 中有多少字符串能够由 startWords 中的 任一 字符串执行上述转换操作获得。返回 targetWords 中这类 字符串的数目 。
 * 注意：你仅能验证 targetWords 中的字符串是否可以由 startWords 中的某个字符串经执行操作获得。startWords  中的字符串在这一过程中 不 发生实际变更。
 * 提示：
 * 1 <= startWords.length, targetWords.length <= 5 * 104
 * 1 <= startWords[i].length, targetWords[j].length <= 26
 * startWords 和 targetWords 中的每个字符串都仅由小写英文字母组成
 * 在 startWords 或 targetWords 的任一字符串中，每个字母至多出现一次
 * @Date: 2022/1/9
 */

public class Solution3 {
    public static int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        Set<Integer> startSet = new HashSet<>();// 位运算状态压缩，将不同字符串映射为整数
        for (String startWord : startWords) {
            int bitSum = 0;
            for (char ch : startWord.toCharArray()) {
                bitSum += 1 << (ch - 'a');
            }
            startSet.add(bitSum);
        }

        for (String targetWord : targetWords) {
            int len = targetWord.length();
            for (int i = 0; i < len; i++) {
                int bitSum = 0;
                for (int j = 0; j < len; j++) {
                    if (targetWord.charAt(i) != targetWord.charAt(j)) {
                        bitSum += 1 << (targetWord.charAt(j) - 'a');
                    }
                }
                if (startSet.contains(bitSum)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String[] startWords = {"ant", "act", "tack"};
//        String[] targetWords = {"tack", "act", "acti"};
        String[] startWords = {"ab", "a"};
        String[] targetWords = {"abc", "abcd"};
        System.out.println(wordCount(startWords, targetWords));
    }
}
