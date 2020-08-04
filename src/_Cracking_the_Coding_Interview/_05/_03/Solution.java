package _Cracking_the_Coding_Interview._05._03;

/**
 * @Description: 面试题 05.03. 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * @Author: Pythagodzilla
 * @Date: 2020/6/29
 */

public class Solution {
    public int reverseBits(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen = curLen - preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }
}
