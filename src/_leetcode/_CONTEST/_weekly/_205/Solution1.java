package _leetcode._CONTEST._weekly._205;

/**
 * @Description: 5507. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s<var> </var>，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * 注意：你 不能 修改非 '?' 字符。
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * @Author: matreeix
 * @Date: 2020/9/6
 */

public class Solution1 {
    //只使用a,b,c三个字母即可
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 3; j++) {
                    if (i > 0 && arr[i - 1] - 'a' == j) continue;//不和前一个字符重复
                    if (i + 1 < arr.length && arr[i + 1] - 'a' == j) continue;//不和后一个字符重复
                    arr[i] = (char) ('a' + j);
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }
}
