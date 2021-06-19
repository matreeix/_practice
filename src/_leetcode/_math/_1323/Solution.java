package _leetcode._math._1323;

/**
 * @Description: 6和9 组成的最大数字
 * <p>
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * 请返回你可以得到的最大数字。
 * @Author: matreeix
 * @Date: 2020/7/9
 */

public class Solution {
    public static int maximum69Number(int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }

    public int maximum69Number2(int num) {
        int temp = num;
        for (int i = 1000; i > 0; i /= 10) {
            if (temp / i == 6)
                return num + (3 * i);
            if (temp > i)
                temp -= (9 * i);
        }
        return num;

    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9999));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9669));
    }
}
