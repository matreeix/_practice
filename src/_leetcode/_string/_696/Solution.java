package _leetcode._string._696;

/**
 * @Description: 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 * 重复出现的子串要计算它们出现的次数。
 * @Date: 2021/3/29
 */

public class Solution {

    public static int countBinarySubstrings(String s) {
        if (s.length() < 2) return 0;
        int a = 0, b = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                b++;
            } else {
                a = b;
                b = 1;
            }
            if (b <= a) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));//6
        System.out.println(countBinarySubstrings("10101"));//4
    }

}
