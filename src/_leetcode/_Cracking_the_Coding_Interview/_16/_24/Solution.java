package _leetcode._Cracking_the_Coding_Interview._16._24;

import java.util.*;

/**
 * @Description: 面试题 16.24. 数对和
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * @Author: matreeix
 * @Date: 2020/12/5
 */

public class Solution {
    //哈希表
    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 2) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        Set<Integer> set = new HashSet<>();
        for (int key : map.keySet()) {
            int key2 = target - key;
            if (map.containsKey(key2) && !set.contains(key)) {
                set.add(key);
                set.add(key2);
                List<Integer> tmp = new ArrayList<>();
                int min = key2 == key ? map.get(key) / 2 : Math.min(map.get(key), map.get(key2));
                tmp.add(key);
                tmp.add(key2);
                while (min-- > 0)
                    res.add(tmp);
            }
        }
        return res;
    }

    //双指针
    public List<List<Integer>> pairSums2(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        int i = 0, j = n - 1;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                ret.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 5, 6, 7, 7, 9};
        System.out.println(pairSums(nums, 12));
    }
}
