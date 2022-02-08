package _leetcode._CONTEST._weekly._279;

import java.util.Arrays;

/**
 * @Description: 2164. 对奇偶下标分别排序
 * 给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值：
 * 按 非递增 顺序排列 nums 奇数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对奇数下标的值排序后变为 [4,3,2,1] 。奇数下标 1 和 3 的值按照非递增顺序重排。
 * 按 非递减 顺序排列 nums 偶数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。偶数下标 0 和 2 的值按照非递减顺序重排。
 * 返回重排 nums 的值之后形成的数组。
 * @Date: 2022/2/7
 */

public class Solution1 {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int[] odd = new int[n / 2];
        int[] even = new int[n - odd.length];
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[idx2++] = nums[i];
            } else {
                odd[idx1++] = nums[i];
            }
        }
        idx2 = 0;
        Arrays.sort(odd);
        Arrays.sort(even);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even[idx2++];
            } else {
                nums[i] = odd[--idx1];
            }
        }
        return nums;
    }
}
