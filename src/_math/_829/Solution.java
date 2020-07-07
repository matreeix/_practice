package _math._829;

/**
 * @Description: 连续整数求和
 * <p>
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 * @Author: Pythagodzilla
 * @Date: 2020/7/7
 */

public class Solution {

    //暴力法，时间复杂度O(n^0.5)
    public static int consecutiveNumbersSum(int N) {
        int count = 0;
        long max = (long) (Math.sqrt(1L + 8L * N) - 1.0) / 2;//可能拆成的最大个数，根据k * (k+1) / 2 = n 求得k
        for (int i = 1; i <= max; i++) {
            if (i % 2 != 0) {//拆成奇数个
                if (N % i == 0)
                    count++;
            } else {//拆成偶数个
                int min = N / i;
                if ((min + min + 1) * i / 2 == N)
                    count++;
            }
        }
        return count;
    }

    //简洁写法
    public static int consecutiveNumbersSum2(int N) {
        int count = 1;
        for (int k = 2; k < Math.sqrt(2 * N); k++) {
            if ((N - (k * (k - 1) / 2)) % k == 0)
                count++;
        }
        return count;
    }

    //最优解法
    public int consecutiveNumbersSum3(int N) {
        int res = 1, count;
        while (N % 2 == 0)
            N /= 2;
        for (int i = 3; i * i <= N; i += 2) {
            count = 0;
            while (N % i == 0) {
                N /= i;
                count++;
            }
            res *= count + 1;
        }
        return N == 1 ? res : res * 2;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(5));//2
        System.out.println(consecutiveNumbersSum(9));//3
        System.out.println(consecutiveNumbersSum(15));//4
        System.out.println(consecutiveNumbersSum2(933320757));//16
    }
}
