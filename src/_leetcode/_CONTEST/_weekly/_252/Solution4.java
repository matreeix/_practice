package _leetcode._CONTEST._weekly._252;

/**
 * @Description: 5833. 统计特殊子序列的数目
 * 特殊序列 是由 正整数 个 0 ，紧接着 正整数 个 1 ，最后 正整数 个 2 组成的序列。
 * 比方说，[0,1,2] 和 [0,0,1,1,1,2] 是特殊序列。
 * 相反，[2,1,0] ，[1] 和 [0,1,2,0] 就不是特殊序列。
 * 给你一个数组 nums （仅 包含整数 0，1 和 2），请你返回 不同特殊子序列的数目 。由于答案可能很大，请你将它对 109 + 7 取余 后返回。
 * 一个数组的 子序列 是从原数组中删除零个或者若干个元素后，剩下元素不改变顺序得到的序列。如果两个子序列的 下标集合 不同，那么这两个子序列是 不同的 。
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 2
 * @Date: 2021/8/1
 */

public class Solution4 {
    public int countSpecialSubsequences(int[] nums) {
        int f0 = 0, f1 = 0, f2 = 0, mod = 1000000007;
        for (int num : nums) {
            if (num == 0) {
                f0 = (f0 * 2 + 1) % mod;
            } else if (num == 1) {
                f1 = (f1 * 2 % mod + f0) % mod;
            } else {
                f2 = (f2 * 2 % mod + f1) % mod;
            }
        }
        return f2;

    }
}
