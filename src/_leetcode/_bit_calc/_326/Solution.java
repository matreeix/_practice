package _leetcode._bit_calc._326;

/**
 * @Description: 判断一个数是否是3的幂次方
 * @Author: matreeix
 * @Date: 2020/3/20
 */
public class Solution {
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if (n % 3 != 0)
                return false;
            else
                n /= 3;
        }
        return true;
    }

    public static boolean isPowerOfThree2(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(5));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(-3));
    }
}
