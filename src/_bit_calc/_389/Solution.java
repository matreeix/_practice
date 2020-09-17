package _bit_calc._389;

/**
 * @Description: 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * @Author: matreeix
 * @Date: 2020/9/17
 */

public class Solution {

    //原理：a^a=0
    public char findTheDifference2(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        int xor = 0;
        for (int i = 0; i < charS.length; i++) {
            xor ^= charS[i] ^ charT[i];
        }

        return (char) (xor ^ charT[charT.length - 1]);
    }
}
