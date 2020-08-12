package _bit_calc._342;

/**
 * @Description: 判断一个数是否是4的幂次方
 * @Author: matreeix
 * @Date: 2020/3/20
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0
                && (num&(num-1)) == 0 //确保为2的幂次
                && (num & 0x55555555) != 0;//确保1的位置在奇数位置
    }

}
