package _leetcode._CONTEST._biweekly._59;

/**
 * @Description: 5834. 使用特殊打字机键入单词的最少时间
 * 有一个特殊打字机，它由一个 圆盘 和一个 指针 组成， 圆盘上标有小写英文字母 'a' 到 'z'。只有 当指针指向某个字母时，它才能被键入。指针 初始时 指向字符 'a' 。
 * 每一秒钟，你可以执行以下操作之一：
 * 将指针 顺时针 或者 逆时针 移动一个字符。
 * 键入指针 当前 指向的字符。
 * 给你一个字符串 word ，请你返回键入 word 所表示单词的 最少 秒数 。
 * 提示：
 * 1 <= word.length <= 100
 * word 只包含小写英文字母。
 * @Date: 2021/8/21
 */

public class Solution1 {
    public int minTimeToType(String word) {
        int res = 0;
        char tmp = 'a';
        for (char ch : word.toCharArray()) {
            int step = Math.abs(tmp - ch);
            res += step > 13 ? 26 - step : step;
            res++;
            tmp = ch;
        }
        return res;
    }
}
