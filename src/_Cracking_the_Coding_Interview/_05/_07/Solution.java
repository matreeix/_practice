package _Cracking_the_Coding_Interview._05._07;


/**
 * @Description: 面试题 05.07. 配对交换
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）
 * @Author: matreeix
 * @Date: 2020/7/31
 */

public class Solution {
    //0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
    //0x55555555 =  1010101010101010101010101010101 (偶数位为0，奇数位为1）
    public int exchangeBits(int num) {
        return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
    }

}
