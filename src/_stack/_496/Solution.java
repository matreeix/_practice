package _stack._496;

import java.util.Arrays;

/**
 * @Description: 下一个更大元素 I
 *
 * s数组1是数组2的子集，在数组2中找到数组1的对应元素后面的更大的元素
 * ，并返回，若不存在就返回-1.
 * @Author: caffebaby
 * @Date: 2019/8/16 20:38
 */
public class Solution {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int i = 0;
        while (i < nums1.length) {
            int j = 0;
            while (j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    j++;
                    while (j < nums2.length) {
                        if (nums1[i] < nums2[j]) {
                            res[i] = nums2[j];
                            break;
                        }
                        j++;
                    }
                }
                j++;
            }
            if (res[i] == 0) res[i] = -1;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums1 = {4, 1, 2};
        int[] nums1 = {1, 3, 5, 2, 4};
//        int[] nums2 = {1, 3, 4, 2};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }


}
