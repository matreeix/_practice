package _greedy._53;

/**
 * @Description: 最大子序和
 * @Author: 67ng
 * @Date: 2020/4/14
 */
public class Solution {
    //贪心算法，时间复杂度O(n)，空间复杂度O(1)
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);//包含当前元素的最大和
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
