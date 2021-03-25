package _string._434;

import java.util.Arrays;

/**
 * @Description: 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * @Date: 2021/3/25
 */

public class Solution {
    public static int countSegments(String s) {
        if (s.length() == 0) return 0;
        String[] strings = s.split(" ");
        int res = 0;
        for (String str : strings)
            if (str.length() > 0)
                res++;
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(countSegments("Hello, my name is John"));
//        System.out.println(countSegments(""));
        System.out.println(countSegments(", , , ,        a, eaefa"));//6
    }

}
