package _leetcode._CONTEST._weekly._269;

/**
 * @Description: 5940. 从数组中移除最大值和最小值
 * 给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。
 * nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。
 * 一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。
 * 返回将数组中最小值和最大值 都 移除需要的最小删除次数。
 * 提示：
 * 1 <= nums.length <= 10^5
 * -105 <= nums[i] <= 10^5
 * nums 中的整数 互不相同
 * @Date: 2021/11/28
 */

public class Solution3 {
    public static int minimumDeletions(int[] nums) {
        if (nums.length == 1) return 1;
        int maxIdx = 0, minIdx = 0, n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
            if (nums[i] < nums[minIdx]) minIdx = i;
        }
        int max = Math.max(minIdx, maxIdx);
        int min = Math.min(minIdx, maxIdx);
        return Math.min(max + 1, Math.min(n - min, min + 1 + n - max));
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        System.out.println(minimumDeletions(nums));
    }
}
