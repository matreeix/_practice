package _leetcode._CONTEST._weekly._250;

/**
 * @Description: 1935. 可以输入的最大单词数
 * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
 * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
 * @Date: 2021/7/19
 */

public class Solution1 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int n = words.length;
        for (String word : words) {
            boolean flag = false;
            for (char ch : brokenLetters.toCharArray()) {
                if (word.contains(ch + "")) {
                    flag = true;
                    break;
                }
            }
            if (flag) n--;
        }
        return n;
    }
}
