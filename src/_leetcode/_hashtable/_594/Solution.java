package _leetcode._hashtable._594;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * @Date: 2021/3/27
 */

public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for (int k : map.keySet()) {
//            if (map.containsKey(k - 1))//并不用检查k-1
//                res = Math.max(map.get(k) + map.get(k - 1), res);
            if (map.containsKey(k + 1))
                res = Math.max(map.get(k) + map.get(k + 1), res);
        }
        return res;
    }

    //排序+滑动窗口
    public int findLHS2(int[] nums) {
        if (nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int left = 0, right = 1, ans = 0;
        while (right < nums.length) {
            // 当窗口内的最大与最小超过1了
            while (left < right && nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1)
                ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

}
