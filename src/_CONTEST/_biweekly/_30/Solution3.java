package _CONTEST._biweekly._30;

import java.util.Arrays;

/**
 * @Description: Minimum Difference Between Largest and Smallest Value in Three Moves
 * <p>
 * Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.
 * Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.
 * @Author: Pythagodzilla
 * @Date: 2020/7/11
 */

public class Solution3 {
    public static int minDifference(int[] nums) {
        if (nums.length <= 3) return 0;
        Arrays.sort(nums);

        int minDif = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < 4; i++) {
            minDif = Math.min(nums[len - 4 + i] - nums[i], minDif);
        }
        return minDif;
    }

    public static void main(String[] args) {
        int[] nums1 = {6, 6, 0, 1, 1, 4, 6};//2
        int[] nums2 = {5, 3, 2, 4};//0
        int[] nums3 = {1, 5, 6, 14, 15};//1

        System.out.println(minDifference(nums1));
        System.out.println(minDifference(nums2));
        System.out.println(minDifference(nums3));
    }
}
