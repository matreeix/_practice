package _leetcode._CONTEST._weekly._269;

import java.util.Arrays;

/**
 * @Description: 5939. 半径为 k 的子数组平均值
 * 给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。
 * 半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）
 * 内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。
 * 构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。
 * x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。
 * 例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 3.75，截断后得到 3 。
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 0 <= nums[i], k <= 10^5
 * @Date: 2021/11/28
 */

public class Solution2 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        if (2 * k + 1 > n) {
            Arrays.fill(avgs, -1);
            return avgs;
        }
        long tmp = 0;
        for (int i = 0; i < 2 * k + 1; i++) tmp += nums[i];
        for (int i = 0; i < n; i++) {
            if (i < k || i > n - k - 1) {
                avgs[i] = -1;
            } else if (i != k) {
                tmp += nums[i + k] - nums[i - k - 1];
                avgs[i] = (int)(tmp / (2L * k + 1L));
            } else {
                avgs[i] = (int)(tmp / (2L * k + 1L));
            }
        }

        return avgs;
    }

    public static void main(String[] args) {
//        int a = 4000000000;
    }
}
