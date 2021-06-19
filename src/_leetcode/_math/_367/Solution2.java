package _leetcode._math._367;

/**
 * @description ：牛顿法
 * @date ： 2020-02-18
 */
public class Solution2 {
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
