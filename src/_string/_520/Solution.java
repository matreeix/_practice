package _string._520;

/**
 * @Description: 520. 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * @Author: matreeix
 * @Date: 2020/9/17
 */

public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean A = false;
        boolean a = false;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
                A = true;
            else
                a = true;
        }
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')
            return !(A && a);
        else
            return !A;
    }

    public boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

}






