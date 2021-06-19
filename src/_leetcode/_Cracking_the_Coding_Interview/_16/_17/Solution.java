package _leetcode._Cracking_the_Coding_Interview._16._17;

/**
 * @Description: 面试题 16.17. 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * 进阶：
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @Author: matreeix
 * @Date: 2020/11/14
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] <= nums[i]) sum = nums[i];
            else sum += nums[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
