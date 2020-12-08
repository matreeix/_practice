package _Cracking_the_Coding_Interview._17._01;

/**
 * @Description: 面试题 17.01. 不用加号的加法
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * @Author: matreeix
 * @Date: 2020/12/8
 */

public class Solution {
    public int add(int a, int b) {
        int carry = 0;
        while (b != 0) {
            carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
