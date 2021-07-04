package _leetcode._CONTEST._weekly._247;

import java.util.Arrays;

/**
 * @Description: 5797. 两个数对之间的最大乘积差
 * 两个数对 (a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。
 * 例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
 * 给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。
 * 返回以这种方式取得的乘积差中的 最大值 。
 * @Date: 2021/6/27
 */

public class Solution1 {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }

    public int maxProductDifference2(int[] nums) {
        int max1 = 0, max2 = 0, min1 = 10001, min2 = 10001;
        for (int i : nums) {
            if (max1 < i) {
                max2 = max1;
                max1 = i;
            } else {
                max2 = Math.max(max2, i);
            }
            if (min1 > i) {
                min2 = min1;
                min1 = i;
            } else {
                min2 = Math.min(min2, i);
            }
        }
        return max1 * max2 - min1 * min2;
    }
}
