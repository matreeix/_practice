package _leetcode._CONTEST._weekly._185;

/**
 * @Description: 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，
 * 而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个空字符串 。
 * @Author: matreeix
 * @Date: 2020/7/22
 */

public class Solution1 {
    public String reformat(String s) {
        if (s == null || s.length() == 0) return "";
        int letter = 0, number = 0;
        for (char c : s.toCharArray()) {
            if (c - 'a' >= 0) letter++;
            else number++;
        }
        if (Math.abs(letter - number) > 1) return "";
        letter = letter - number == 1 ? 0 : 1;
        number = letter == 1 ? 0 : 1;
        char[] chars = s.toCharArray();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                chars[number] = c;
                number += 2;
            } else {
                chars[letter] = c;
                letter += 2;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println('1' - 'a');
        System.out.println('b' - 'a');
    }
}