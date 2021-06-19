package _leetcode._CONTEST._biweekly._53;

import java.util.Arrays;

/**
 * @Description: 5756. 两个数组最小的异或值之和
 * 给你两个整数数组 nums1 和 nums2 ，它们长度都为 n 。
 * 两个数组的 异或值之和 为 (nums1[0] XOR nums2[0]) + (nums1[1] XOR nums2[1]) + ... + (nums1[n - 1] XOR nums2[n - 1]) （下标从 0 开始）。
 * 比方说，[1,2,3] 和 [3,2,1] 的 异或值之和 等于 (1 XOR 3) + (2 XOR 2) + (3 XOR 1) = 2 + 0 + 2 = 4 。
 * 请你将 nums2 中的元素重新排列，使得 异或值之和 最小 。
 * 请你返回重新排列之后的 异或值之和 。
 * <p>
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 14
 * 0 <= nums1[i], nums2[i] <= 10^7
 * @Created by: matreeix
 * @Date: 2021/5/29
 */
public class Solution4 {
    private int dfs(int[] dp, int[] a, int[] b, int i, int mask) {
        if (i >= a.length) return 0;
        if (dp[mask] == Integer.MAX_VALUE)
            for (int j = 0; j < b.length; ++j)//遍历num2
                if ((mask & (1 << j)) == 0)//判断mask的第j位是否为0
                    dp[mask] = Math.min(dp[mask], (a[i] ^ b[j]) + dfs(dp, a, b, i + 1, mask + (1 << j)));
        return dp[mask];
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int dp[] = new int[1 << nums2.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return dfs(dp, nums1, nums2, 0, 0);
    }
}
