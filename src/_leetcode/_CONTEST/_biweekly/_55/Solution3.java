package _leetcode._CONTEST._biweekly._55;

/**
 * @Description: 5782. 最大子序列交替和
 * 一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。
 * 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。
 * 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。
 * 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * @Created by: matreeix
 * @Date: 2021/6/26
 */
public class Solution3 {
    public static long maxAlternatingSum(int[] nums) {
        long res = 0;
        int i = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i - 1] <= nums[i]) i++;
            res += nums[i - 1];//波峰
            while (i < nums.length && nums[i - 1] >= nums[i]) i++;
            res = i == nums.length ? res : res - nums[i - 1];//波谷
        }
        return res;
    }

    //DP
    public long maxAlternatingSum2(int[] A) {
        long odd = 0, even = 0;
        for (int a : A) {
            even = Math.max(even, odd + a);
            odd = even - a;
        }
        return even;
    }
}
