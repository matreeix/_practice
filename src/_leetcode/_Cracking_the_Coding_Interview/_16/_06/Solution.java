package _leetcode._Cracking_the_Coding_Interview._16._06;

import java.util.Arrays;

/**
 * @Description: 面试题 16.06. 最小差
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * @Author: matreeix
 * @Date: 2020/10/29
 */

public class Solution {

    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < a.length && j < b.length; ) {
            res = Math.min(res, Math.abs((long) a[i] - (long) b[j]));
            if (a[i] < b[j]) i++;
            else j++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int[] a = {-2147483648, 1};
        int[] b = {2147483647, 0};
        System.out.println(smallestDifference(a,b));
    }
}
