package _CONTEST._weekly._197;

import java.util.Arrays;

/**
 * @Description: 仅为1的子字符串数目
 * <p>
 * 给定一个二进制字符串  s （仅包含“ 0”和“ 1”的字符串）。
 * 返回所有字符为1的子字符串的数目。
 * 由于答案可能太大，请以10 ^ 9 + 7为模返回。
 * @Author: matreeix
 * @Date: 2020/7/12
 */

public class Solution2 {

    public static int numSub(String s) {
        int mod = 1000000007;
        String[] strings = s.split("0");
        int res = 0;
        for (String string : strings) {
            long n = string.length();
            if (n > 0) {
                long count = n * (n + 1L) / 2L % mod;
                res = (res + (int) count) % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((int)100000L * 100001 / 2);
        System.out.println(Integer.MAX_VALUE);

    }
}
