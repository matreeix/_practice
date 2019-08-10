package _219;

import java.util.*;

/**
 * @Description: 寻找是否存在满足索引限制的重复数
 * @Author: leetcode@southpenguin
 * @Date: 2019/8/10 9:54
 */
public class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);//维护一个k长度的滑动窗口
            if (!set.add(nums[i])) return true;//表明存在重复元素且索引距离小于k
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 1, 2, 3};

        System.out.println(containsNearbyDuplicate(nums1, 3));
        System.out.println(containsNearbyDuplicate(nums2, 2));
    }
}
