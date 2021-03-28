package _TP._643;

/**
 * @Description: 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * @Date: 2021/3/28
 */

public class Solution {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > k - 1) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                max = Math.max(max, sum);
            }
        }
        return max / (double) k;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int[] nums2 = {0, 4, 0, 3, 2};
        System.out.println(findMaxAverage(nums1, 4));
        System.out.println(findMaxAverage(nums2, 1));
    }

}
