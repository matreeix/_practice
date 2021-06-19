package _leetcode._math._1780;

/**
 * @Description: 1780. 判断一个数字是否可以表示成三的幂的和
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * @Date: 2021/3/8
 */

public class Solution {
    public static boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 3 == 1) {
                n -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean checkPowersOfThree2(int n) {
        return n < 2 || (n % 3 != 2 && checkPowersOfThree(n / 3));
    }

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
        System.out.println(checkPowersOfThree(91));
        System.out.println(checkPowersOfThree(21));
    }
}
