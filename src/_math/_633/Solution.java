package _math._633;

/**
 * @description ：判断平方数和
 * @date ： 2020-02-18
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int cur = a * a + b * b;
            if (cur < c) {
                a++;
            } else if (cur > c) {
                b--;
            } else {
                return true;
            }
        }
        return false;

    }
}
