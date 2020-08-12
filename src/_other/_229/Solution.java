package _other._229;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 找出数组中所用元素个数超过总数1/3的元素
 * @Author: matreeix
 * @Date: 2019/7/27 23:03
 */
public class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
//            return null;不能返回空
        List<Integer> result = new ArrayList<>();
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)//该条件至少占1/3总次数
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {//(仅讨论只有一个返回值)符合该条件，走到这步的次数不会超过1/3总次数，原因是当其他各元素都不相同时减得最多，但也是每两次减一次（其中一次要赋值），所以最多减小次数小于(2/3)/2即1/3
                count1--;
                count2--;
            }
        }
        System.out.println(count1);
        System.out.println(count2);
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        if (count1 > len / 3)
            result.add(number1);
        if (count2 > len / 3)
            result.add(number2);
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        int[] nums1 = {2, 1, 1, 1, 3, 3, 2, 7};
        int[] nums2 = {1, 1, 1, 1, 1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums4 = {1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4};
//        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums3));
        System.out.println(majorityElement(nums4));
    }
}
