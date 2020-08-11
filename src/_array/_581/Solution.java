package _array._581;

import java.util.Arrays;

/**
 * @Description: 最短未排序的连续子数组
 * @Author: caffebaby
 * @Date: 2020/3/7
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -2,//记录子数组的左右边界
                min = nums[nums.length - 1], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);//从左到右记录最大值
            min = Math.min(min, nums[nums.length - 1 - i]);//从右到左记录最小值
            if (nums[i] < max)//max=nums[k],且k<i,故更新右边界
                right = i;
            if (nums[nums.length - 1 - i] > min)//同理，有值比左边界还小，更新左边界
                left = nums.length - 1 - i;
        }
        return right - left + 1;
    }


    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println((new Solution()).findUnsortedSubarray(arr));
    }

}
