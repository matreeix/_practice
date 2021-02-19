package _array._1749;

/**
 * @Description: 1749. 任意子数组和的绝对值的最大值
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * @Date: 2021/2/17
 */

public class Solution {
    //abs子数组总和 = 一个前缀总和 - 另一个前缀总和 <= 最大前缀总和 - 最小前缀总和
    public int maxAbsoluteSum(int[] nums) {
        int s = 0, min = 0, max = 0;
        for (int a : nums) {
            s += a;
            min = Math.min(min, s);//最大前缀和
            max = Math.max(max, s);//最小前缀和
        }
        return max - min;
    }

}
