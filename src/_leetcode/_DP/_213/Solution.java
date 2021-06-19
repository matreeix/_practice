package _leetcode._DP._213;

/**
 * @description ：打家劫舍2
 * @date ： 2020-04-10
 */
public class Solution {
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        return Math.max(nums[0] + minRob(nums, 2, nums.length - 2),//打劫第一间房子
                minRob(nums, 1, nums.length - 1));//不打劫第一间房子
    }

    private static int minRob(int[] nums, int start, int end) {
        if (start > end)
            return 0;
        int[] memo = new int[end - start + 1];
        memo[0] = nums[start];
        for (int i = start + 1; i <= end; i++)
            memo[i - start] = Math.max(memo[i - start - 1], nums[i] + (i >= start + 2 ? memo[i - start - 2] : 0));
        return memo[memo.length - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 3, 4};
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(minRob(nums1, 0, nums1.length - 1));
        System.out.println(minRob(nums2, 0, nums2.length - 1));
    }
}
