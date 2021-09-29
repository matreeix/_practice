package _leetcode._array._2012;

/**
 * @Description: 2012. 数组美丽值求和
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 * @Date: 2021/9/29
 */

public class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        int[] mid = new int[n];
        int max = nums[0];
        int min = nums[n - 1];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) mid[i]++;
            if (nums[i] > max) {
                max = nums[i];
                tmp[i] = 2;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            } else {
                tmp[i] -= 2;
            }
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += tmp[i] == 2 ? tmp[i] : mid[i];
        }
        return res;
    }
}
