package _leetcode._CONTEST._biweekly._69;

import java.util.Locale;

/**
 * @Description: 5960. 将标题首字母大写
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 * @Date: 2022/1/8
 */

public class Solution1 {
    public String capitalizeTitle(String title) {
        title = title.toLowerCase();
        String[] strings = title.split(" ");
        StringBuffer res = new StringBuffer();
        for (String s : strings) {
            if (s.length() > 2) {
                res.append((char) (s.charAt(0) - 32));
                res.append(s.substring(1));
            } else {
                res.append(s);
            }
            res.append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(("asdf asdfaf1   ASDFASDF").toUpperCase());
    }
}
