package _leetcode.backtracking._2044;

import java.util.Arrays;

/**
 * @Description: 2044. 统计按位或能得到最大值的子集数目
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * @Date: 2021/11/9
 */

public class Solution {
    private static int max;
    private static int res;

    // 回溯解法
    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            max |= num;
        }
        backTrack(nums, 0, 0);
        return res;
    }

    private void backTrack(int[] nums, int idx, int cur) {
        if (cur == max) {
            res += 1 << (nums.length - idx);
            return;
        }
        if (idx == nums.length) {
            return;
        }
        backTrack(nums, idx + 1, cur | nums[idx]);
        backTrack(nums, idx + 1, cur);
    }

    // DP解法
    public int countMaxOrSubsets2(int[] nums) {
        int max = 0, MAX = 0, bit = 0;
        for (int num : nums) MAX = Math.max(MAX, num);
        while (MAX > 0) {
            MAX >>= 1;
            bit++;
        }
        int[] dp = new int[(int) Math.pow(2, bit) + 1];// dp[sum]表示按位或的子集数sum。
        dp[0] = 1;
        for (int num : nums) {
            for (int i = max; i >= 0; --i) {
                dp[i | num] += dp[i];
            }
            max |= num;
        }
        return dp[max];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {3, 2, 1, 5};
        int[] nums = {2, 2, 2};
        System.out.println(s.countMaxOrSubsets2(nums));
    }
}
