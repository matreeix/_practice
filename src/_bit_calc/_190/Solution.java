package _bit_calc._190;

/**
 * @Description: 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 * @Author: matreeix
 * @Date: 2020/10/19
 */

public class Solution {
    //翻转n的二进制形式
    //调用jdk函数
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    //构造法
    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;//得到n的最末位
            n >>= 1;//n从右往左遍历
            res <<= 1;//res从左往右赋值
            res |= bit;//将n的末位赋给res的最末位
        }
        return res;
    }

}
