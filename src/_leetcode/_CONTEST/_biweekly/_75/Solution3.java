package _leetcode._CONTEST._biweekly._75;

import java.util.Arrays;

/**
 * @Description: 6035. 选择建筑的方案数
 * 给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
 * s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
 * s[i] = '1' 表示第 i 栋建筑是一间餐厅。
 * 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
 * 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
 * 请你返回可以选择 3 栋建筑的 有效方案数 。
 * 提示：
 * 3 <= s.length <= 10^15
 * s[i] 要么是 '0' ，要么是 '1'
 * @Date: 2022/4/3
 */

public class Solution3 {
    public static long numberOfWays(String s) {
        long res101 = 0;
        long res010 = 0;
        int n = s.length();
        int[] cnt0 = new int[n];// 统计前缀0的个数
        int[] cnt1 = new int[n];// 统计前缀1的个数
        if (s.charAt(0) == '0') cnt0[0] = 1;
        else cnt1[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                cnt0[i] = cnt0[i - 1] + 1;
                cnt1[i] = cnt1[i - 1];
            } else {
                cnt1[i] = cnt1[i - 1] + 1;
                cnt0[i] = cnt0[i - 1];
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                res010 += (long) cnt0[i] * (cnt0[n - 1] - cnt0[i]);
            } else {
                res101 += (long) cnt1[i] * (cnt1[n - 1] - cnt1[i]);
            }
        }
        return res010 + res101;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays("001101"));
    }
}
