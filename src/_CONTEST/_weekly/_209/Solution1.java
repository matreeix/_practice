package _CONTEST._weekly._209;

import java.util.Arrays;

/**
 * @Description: 1608. 特殊数组的特征值
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * <p>
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 * @Author: matreeix
 * @Date: 2020/10/8
 */

public class Solution1 {
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= nums[0]) return nums.length;
        int x = nums.length - 1;
        int i = 1;
        while (x > 0) {
            if (x <= nums[i] && x > nums[i - 1]) {
                return x;
            } else {
                x--;
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};//x=5
        int[] nums = {0, 1, 2, 3, 4, 4, 6, 7, 8, 9};//x=5
        System.out.println(specialArray(nums));
    }

}