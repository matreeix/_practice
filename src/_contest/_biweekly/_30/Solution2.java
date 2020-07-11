package _contest._biweekly._30;

import java.util.Arrays;

/**
 * @Description: 已排序子数组和的范围总和
 * <p>
 * 给定nums由n正整数组成的数组。您计算了该数组中所有非空连续子数组的总和，然后以非降序对其进行排序，从而创建了一个新的n * (n + 1) / 2 数字数组。
 * 返回新数组中从索引left到索引right（从1开始索引）的数字总和。 由于答案可能是巨大的数字，因此以10 ^ 9 + 7为模返回。
 * @Author: Pythagodzilla
 * @Date: 2020/7/11
 */

public class Solution2 {
    //暴力法，直接构造和数组，会超出时间限制
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n * (n + 1) / 2];
        int mod = 1000000007;
        int mark = 0;
        for (int bound = 1; bound <= n; bound++) {
            for (int i = 0; i + bound <= nums.length; i++) {
                int sum = 0;
                for (int j = i; j < i + bound; j++) {
                    sum = (sum + nums[j]) % mod;
                }
                sums[mark++] = sum;
            }
        }

        Arrays.sort(sums);
        int res = 0;
        for (int index = left - 1; index < right; index++) {
            res = (res + sums[index]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }
}
