package _leetcode._math._31;

import java.util.Arrays;

/**
 * @Description: 下一个排列
 * @Author: matreeix
 * @Date: 2020/6/11
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {//找到第一个要交换的位
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {//找到第二个要交换的位
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    //从start开始翻转数组
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
            System.out.println("交换数组索引越界");
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 5, 9, 8, 6, 4, 3, 2};
        int[] nums2 = {1, 3, 4, 5, 9, 8, 5, 4, 3, 2};
//        int[] nums3 = {9, 8, 6, 4, 3, 2};
//        int[] nums4 = {9, 8, 6, 4, 3, 2, 1};
        int[] nums5 = {1, 3, 4, 5, 9, 8, 6, 4, 3, 2, 1};
        Solution s = new Solution();
        s.nextPermutation(nums1);
        s.nextPermutation(nums2);
//        s.nextPermutation(nums3);
//        s.nextPermutation(nums4);
        s.nextPermutation(nums5);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
//        System.out.println(Arrays.toString(nums3));
//        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(nums5));

    }

}
