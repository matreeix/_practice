package _math._50;

/**
 * @Description: 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @Author: Pythagodzilla
 * @Date: 2020/7/24
 */

public class Solution {
    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static double myPow2(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            return myPow(x, -Integer.MAX_VALUE) * 1 / x;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow2(x * x, n / 2) : x * myPow2(x * x, n / 2);

    }

    public static void main(String[] args) {
        System.out.println(myPow2(0.5, Integer.MIN_VALUE));
        System.out.println(-Integer.MIN_VALUE);
    }
}
