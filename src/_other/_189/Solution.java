package _other._189;

import java.util.Arrays;

/**
 * @Description: 将一个数组向右“前进”k步
 * @Author: 67ng
 * @Date: 2019/7/31 20:13
 */
public class Solution {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;

        int[] new_nums = new int[len];

        for (int i = 0; i < len; i++) {
            new_nums[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = new_nums[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 0;
//        int k = 1;
//        int k = 2;
//        int k = 3;
        int k = 10;

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
