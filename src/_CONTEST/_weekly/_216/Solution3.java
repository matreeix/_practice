package _CONTEST._weekly._216;

/**
 * @Description: 1664. 生成平衡数组的方案数
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * <p>
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * <p>
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 * @Author: matreeix
 * @Date: 2020/11/24
 */

public class Solution3 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++)
            dp[i] = dp[i - 1] + (i % 2 == 0 ? nums[i - 1] : -nums[i - 1]);

        int ans = 0;
        for (int i = 1; i < dp.length; i++)
            if (dp[i - 1] == (dp[n] - dp[i]))
                ans += 1;

        return ans;
    }

}
