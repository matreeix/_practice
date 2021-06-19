package _leetcode._hashtable._217;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 寻找是否存在重复数
 * @Author: matreeix
 * @Date: 2019/8/10 9:53
 */
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));
    }
}
