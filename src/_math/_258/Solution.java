package _math._258;

/**
 * @Description: 各位相加
 * <p>
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * @Author: caffebaby
 * @Date: 2020/6/29
 */

public class Solution {
    //暴力法，循环+递归，超出时间限制
    public int addDigits(int num) {
        if (num / 10 == 0) return num;
        int res = 0;
        int remainder = Integer.MAX_VALUE;
        while (remainder != 0) {
            remainder = num / 10;
            res += num % 10;
        }
        return addDigits(res);
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
