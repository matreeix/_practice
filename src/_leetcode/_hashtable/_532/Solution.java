package _leetcode._hashtable._532;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 532. 数组中的 k-diff 数对
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 * @Date: 2021/7/9
 */

public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int k) {
        // 0 1 2 3 4
        // 3 1 4 1 5
        // | |     |
        //   i m     j

        // Gotcha; unique pairs - hashset to push each k to hashset.

        //HashSet<Integer> uniqueMvalues = new HashSet();
        Arrays.sort(nums);

        int left = 0;
        int right = left + 1;

        // if(nums.length==1) return 0;
        int count = 0;
        //count = Math.abs(nums[i]-nums[j]) == k ? count++ : count;
        while (left < nums.length && right < nums.length) {
            //if(!uniqueMvalues.contains(nums[m])) {
            //   int diff = Math.abs(nums[left]-nums[right]);
            int diff = nums[right] - nums[left];
            if (left == right || diff < k) {
                right++;
            } else if (diff > k) {
                left++;
            } else {
                count += 1;
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        return count;
    }

    public int findPairs3(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int lo = 0, hi = 0, res = 0;

        while (hi < nums.length) {
            if (hi <= lo || nums[hi] - nums[lo] < k) hi++;
            else if (lo > 0 && nums[lo - 1] == nums[lo] || nums[hi] - nums[lo] > k) lo++;
            else { res++; lo++; }
        }
        return res;
    }
}
