package _leetcode._bit_calc._371;

/**
 * @Description: 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * @Created by: matreeix
 * @Date: 2021/5/2
 */
public class Solution {

    public int getSum(int a, int b) {
        while(b != 0){//重复1、2，直到进位数为0
            int temp = a ^ b;//1.各位数相加，不算进位
            b = (a & b) << 1;//2.计算进位
            a = temp;
        }
        return a;
    }

}
