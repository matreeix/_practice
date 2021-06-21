package _leetcode._CONTEST._weekly._246;

/**
 * @Description: 5788. 字符串中的最大奇数
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * 子字符串 是字符串中的一个连续的字符序列。
 * @Created by: matreeix
 * @Date: 2021/6/20
 */
public class Solution1 {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1)
                return num.substring(0, i + 1);
        }
        return "";
    }


}
