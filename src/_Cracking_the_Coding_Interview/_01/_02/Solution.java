package _Cracking_the_Coding_Interview._01._02;

import java.util.Arrays;

/**
 * @Description: 判断是否为字符串重排
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * @Author: Pythagodzilla
 * @Date: 2020/6/29
 */

public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        if (s1.length()!=s2.length())return false;
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }
}
