package _string._1324;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 竖立打印单词
 * <p>
 * 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 * 每个单词只能放在一列上，每一列中也只能有一个单词。
 * 注：
 * 1.1 <= s.length <= 200
 * 2.s仅含大写英文字母。
 * 3.题目数据保证两个单词之间只有一个空格。
 * @Author: Pythagodzilla
 * @Date: 2020/7/9
 */

public class Solution {
    public static List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] strings = s.split(" ");
        int maxLen = -1;
        for (String string : strings)
            maxLen = Math.max(maxLen, string.length());
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String string : strings) {
                if (i < string.length())
                    sb.append(string.charAt(i));
                else
                    sb.append(" ");
            }
            String str = trim(sb.toString());
//            while (sb.length() > 1 && sb.charAt(sb.length() - 1) == ' ') {
//                sb.deleteCharAt(sb.length() - 1);
//            }
            res.add(str);
        }
        return res;
    }

    private static String trim(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') index--;
        return s.substring(0, index + 1);
    }

    public static void main(String[] args) {
        String s1 = "HOW ARE YOU";
        String s2 = "TO BE OR NOT TO BE";
        String s3 = "CONTEST IS COMING";

        System.out.println(printVertically(s1));
        System.out.println(printVertically(s2));
        System.out.println(printVertically(s3));
    }
}
