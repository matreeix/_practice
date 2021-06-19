package _leetcode._graph._473;

import java.util.Arrays;

/**
 * @Description: 用数组组成正方形
 * @Author: matreeix
 * @Date: 2020/3/10
 */
public class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum == 0 || sum % 4 != 0) return false;

        Arrays.sort(nums);
        return dfs(nums, new int[4], nums.length - 1, sum / 4);
    }

    private boolean dfs(int[] nums, int[] sum, int index, int target) {
        if (index == -1) {
            if (sum[0] == target && sum[1] == target && sum[1] == target)
                return true;
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[index] > target)
                continue;
            sum[i] += nums[index];
            if (dfs(nums, sum, index - 1, target))
                return true;
            sum[i] -= nums[index];//注意回溯

        }
        return false;
    }
}
