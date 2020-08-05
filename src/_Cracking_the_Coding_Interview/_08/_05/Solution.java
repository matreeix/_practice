package _Cracking_the_Coding_Interview._08._05;

/**
 * @Description: 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * @Author: Pythagodzilla
 * @Date: 2020/8/5
 */

public class Solution {
    public static int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int[] dp = new int[min + 1];
        dp[1] = max;
        for (int i = 2; i < dp.length; i++)
            dp[i] = dp[i - 1] + max;
        return dp[min];
    }

    public static void main(String[] args) {
        System.out.println(multiply(3,4));
        System.out.println(multiply(5,5));

    }
}
