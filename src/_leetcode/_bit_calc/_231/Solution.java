package _leetcode._bit_calc._231;

/**
 * @Description: 判断一个数是否是2的幂次方
 * @Author: matreeix
 * @Date: 2020/3/20
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
