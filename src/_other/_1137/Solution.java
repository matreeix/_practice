package _other._1137;

/**
 * @Description: 三阶斐波拉切数列F(n) = F(n-1) + F(n-2) + F(n-3)
 * @Author: Leetcode@lee215
 * @Date: 2019/8/23 19:48
 */
public class Solution {

    public int tribonacci(int n) {

        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;

    }
}
