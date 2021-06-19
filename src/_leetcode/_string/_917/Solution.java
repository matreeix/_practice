package _leetcode._string._917;

/**
 * @Description: 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * @Created by: matreeix
 * @Date: 2021/6/15
 */
public class Solution {

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        int a = -1, b = -1;
        while (i < j) {
            if (isLetter(chars, i) && isLetter(chars, j)) {
                swap(chars, i, j);
                i++;
                j--;
            } else {
                if (!isLetter(chars, i)) {
                    i++;
                }
                if (!isLetter(chars, j)) {
                    j--;
                }
            }

        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private boolean isLetter(char[] chars, int i) {
        return ('a' <= chars[i] && chars[i] <= 'z') || ('A' <= chars[i] && chars[i] <= 'Z');
    }
}
