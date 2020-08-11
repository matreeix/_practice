package _math._357;

/**
 * @Description: 各位数都不同的数字个数
 * <p>
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。
 * @Author: caffebaby
 * @Date: 2020/7/18
 */

public class Solution {

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int count = 9, res = 10;
        for (int i = 1; i <= Math.min(10, n-1); i++) {
            count *= 10 - i;
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(12));
        System.out.println(countNumbersWithUniqueDigits(10));
        System.out.println(countNumbersWithUniqueDigits(3));
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(1));
    }
}
