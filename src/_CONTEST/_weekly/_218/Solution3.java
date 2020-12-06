package _CONTEST._weekly._218;

/**
 * @Description: 5620. 连接连续二进制数字
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 * @Author: matreeix
 * @Date: 2020/12/6
 */

public class Solution3 {
    public static int concatenatedBinary(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int mod = 1000000007;
        for (int i = 2; i < dp.length; i++) {
            int bit = i;
            dp[i] = dp[i - 1];
            while (bit > 0) {
                dp[i] = (dp[i] * 2) % mod;
                bit >>= 1;
            }
            dp[i] = (dp[i] + i) % mod;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));//1
        System.out.println(concatenatedBinary(2));//6
        System.out.println(concatenatedBinary(3));//27
        System.out.println(concatenatedBinary(12));//505379714
//        System.out.println(concatenatedBinary(1));
    }
}
