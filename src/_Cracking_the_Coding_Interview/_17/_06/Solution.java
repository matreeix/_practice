package _Cracking_the_Coding_Interview._17._06;

/**
 * @Description: 面试题 17.06. 2出现的次数
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * @Author: matreeix
 * @Date: 2020/12/9
 */

public class Solution {
    public static int numberOf2sInRange(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = (int) Math.log10(n) + 1;
        int[][] dp = new int[digit + 1][2];
        // dp[i][0] = numberOf2sInRange(n % pow(10, i)) 保存0~n的1-i位组成的数包含2的个数
        // dp[i][1] = numberOf2sInRange(99..9) 保存i位均为9包含2的个数
        dp[1][0] = n % 10 >= 2 ? 1 : 0;
        dp[1][1] = 1;
        for (int i = 2; i <= digit; i++) {
            int k = n / ((int) Math.pow(10, i - 1)) % 10;
            dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
            if (k == 2) {
                dp[i][0] += n % (int) Math.pow(10, i - 1) + 1;
            } else if (k > 2) {
                dp[i][0] += (int) Math.pow(10, i - 1);
            }
            dp[i][1] = 10 * dp[i - 1][1] + (int) Math.pow(10, i - 1); //计算1-i位均为9的值包含2的个数
        }
        return dp[digit][0];
    }

    public static void main(String[] args) {
        System.out.println(numberOf2sInRange(25));
    }
}
