package _math._628;

import java.util.Arrays;

/**
 * @Description: 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积
 * @Author: matreeix
 * @Date: 2020/9/24
 */

public class Solution {
    //排序法
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[0] * nums[1] * nums[n - 1];
        int b = nums[n - 3] * nums[n - 2] * nums[n - 1];
        return Math.max(a, b);
    }

    //非排序
    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }

            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
