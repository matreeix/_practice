package _leetcode._string._151;

/**
 * @Description: 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * 1.无空格字符构成一个 单词 。
 * 2.输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 3.如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @Date: 2021/4/8
 */

public class Solution {

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!"".equals(strings[i].trim())) {
                sb.append(strings[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" asd sid  sdad    astd  "));
    }
}
