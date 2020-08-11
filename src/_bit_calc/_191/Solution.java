package _bit_calc._191;

/**
 * @Description: 1的个数
 * <p>
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * @Author: caffebaby
 * @Date: 2020/7/2
 */

public class Solution {
    // you need to treat n as an unsigned value
    //循环和位移动
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                bits++;

            mask <<= 1;
        }
        return bits;
    }

    //位运算,原理:对于任意数字 n ，将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public int hammingweight3(int n){
        return Integer.bitCount(n);
    }

}
