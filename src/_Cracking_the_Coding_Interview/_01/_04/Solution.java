package _Cracking_the_Coding_Interview._01._04;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @Description: 回文排列
 * <p>
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * @Author: Pythagodzilla
 * @Date: 2020/6/30
 */

public class Solution {
    //位图法
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 1)
            return true;
        long highBmp = 0, lowBmp = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= 64)
                highBmp ^= 1L << s.charAt(i) - 64;
            else
                lowBmp ^= 1L << s.charAt(i);

        return Long.bitCount(highBmp) + Long.bitCount(lowBmp) <= 1;
    }

    public static void main(String[] args) {
        String s1 = "eerrt";//1
        String s2 = "qqwweerrttt";//1
        String s3 = "qqwwfeerrttt";//2
        String s4 = "qqwwffeerrtttt";//0
        String s5 = "as";//2
        String s6 = "carerac";//1
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome(s1));
        System.out.println(solution.canPermutePalindrome(s2));
        System.out.println(solution.canPermutePalindrome(s3));
        System.out.println(solution.canPermutePalindrome(s4));
        System.out.println(solution.canPermutePalindrome(s5));
        System.out.println(solution.canPermutePalindrome(s6));
    }
}