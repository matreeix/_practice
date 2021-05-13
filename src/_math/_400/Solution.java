package _math._400;

/**
 * @Description: 400. 第 N 位数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 * 注意：n 是正数且在 32 位整数范围内（n < 2^31）。
 * @Created by: matreeix
 * @Date: 2021/5/12
 */
public class Solution {

    public int findNthDigit(int n) {
        long num = n;

        long bit = 1;
        long max = 9;

        while (n > 0) {
            //判断不在当前位数内
            if (num - max * bit > 0) {
                num = num - max * bit;
                bit++;
                max = max * 10;
            } else {
                long count = num / bit;
                long left = num % bit;
                if (left == 0) {
                    return (int) (((long) Math.pow(10, bit - 1) + count - 1) % 10);
                } else {
                    return (int) (((long) Math.pow(10, bit - 1) + count) / ((long) Math.pow(10, (bit - left))) % 10);
                }
            }
        }
        return 0;
    }
}
