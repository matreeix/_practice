package _CONTEST._LCP._28;

import java.util.Arrays;

/**
 * @Description: LCP 28. 采购方案
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * 提示：
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i], target <= 10^5
 * @Date: 2021/4/10
 */

public class Solution {

    //O(nlogn)
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, n = nums.length;
        for (int j = n - 1, i = 0; i < n; i++) {
            while (j > i && nums[i] + nums[j] > target) --j;
            if (j <= i) break;
            res = (res + j - i) % 1000000007;
        }
        return res % 1000000007;
    }

    int dp[] = new int[100001];//元素值哈希

    //O(n)
    public int purchasePlans2(int[] nums, int target) {
        for (int num : nums) dp[num]++;
        for (int i = 1; i < target; i++) dp[i] += dp[i - 1];//累计等于或小于当前值的数量

        long ans = 0;
        for (int num : nums) {
            if (num > target) continue;
            int v = target - num;
            ans += dp[v];
            if (v >= num) ans--;//排除统计到自身的情况,2 * num <= target
        }
        return (int) ((ans / 2) % 1000000007);
    }

}
