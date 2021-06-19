package _leetcode._Cracking_the_Coding_Interview._08._01;

/**
 * @Description: 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * @Author: matreeix
 * @Date: 2020/8/5
 */

public class Solution {
    public static int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }

    //高效写法
    public int waysToStep2(int n) {
        if (n == 1 || n == 2) return n;
        if (n == 3) return 4;
        int a = 1, b = 2, c = 4;
        for (int i = 4; i <= n; i++) {
            int t = (a + b) % 1000000007;
            t = (t + c) % 1000000007;
            a = b;
            b = c;
            c = t;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(5));
    }
}
