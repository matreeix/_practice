package _leetcode._CONTEST._weekly._202;

import java.util.HashMap;

/**
 * @Description: 5490. 吃掉 N 个橘子的最少天数
 * 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
 * <p>
 * 1.吃掉一个橘子。
 * 2.如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 * 3.如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 * 每天你只能从以上 3 种方案中选择一种方案。
 * <p>
 * 请你返回吃掉所有 n 个橘子的最少天数。
 * @Author: matreeix
 * @Date: 2020/8/15
 */

public class Solution4 {
    //超出内存限制
    public static int minDays2(int n) {
        int[] dp = new int[n + 1];//吃掉i个橘子的最少天数
        dp[0] = 0;
        dp[1] = 1;
        int tmp1 = Integer.MAX_VALUE;
        int tmp2 = Integer.MAX_VALUE;
        int tmp3;
        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0)
                tmp1 = dp[i / 2] + 1;
            if (i % 3 == 0)
                tmp2 = dp[i / 3] + 1;
            tmp3 = dp[i - 1] + 1;
            dp[i] = Math.min(tmp1, Math.min(tmp2, tmp3));
            tmp1 = Integer.MAX_VALUE;
            tmp2 = Integer.MAX_VALUE;
        }
        return dp[n];
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    //DP+hashmap,使用map来记忆化，减少了内存占用
    public static int minDays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n))
            return map.get(n);
        map.put(n, Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1));
        return Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);
    }

    //直接递归不使用map会LTE
    public static int minDays3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return 1 + Math.min(minDays3(n / 2) + n % 2, minDays3(n / 3) + n % 3);
    }


    public static void main(String[] args) {
//        System.out.println(minDays2(1));//1
//        System.out.println(minDays2(6));//3
//        System.out.println(minDays2(10));//4
//        System.out.println(minDays2(56));//6
//        System.out.println(minDays2(61455274));//29
        System.out.println(minDays3(61455274));//29
//
//        System.out.println(minDays(16));//5
        System.out.println(minDays3(16));//5


    }
}
