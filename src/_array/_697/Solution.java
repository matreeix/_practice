package _array._697;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * @Date: 2021/3/29
 */

public class Solution {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();//<元素值，{频数，起始索引，终止索引}>
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] tmp = map.get(nums[i]);
                tmp[0] += 1;
                tmp[2] = i;
                map.put(nums[i], tmp);
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int minL = 50000, maxF = 0;
        for (int[] arr : map.values()) {
            if (arr[0] > maxF) {//更大的频数直接更新长度
                maxF = arr[0];
                minL = arr[2] - arr[1] + 1;
            } else if (arr[0] == maxF) {//频数相同时取最小的长度
                minL = Math.min(minL, arr[2] - arr[1] + 1);
            }
        }
        return minL;
    }

    public int findShortestSubArray2(int[] A) {
        Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0;
        for (int i = 0; i < A.length; ++i) {
            first.putIfAbsent(A[i], i);
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
            if (count.get(A[i]) > degree) {
                degree = count.get(A[i]);
                res = i - first.get(A[i]) + 1;
            } else if (count.get(A[i]) == degree)
                res = Math.min(res, i - first.get(A[i]) + 1);
        }
        return res;
    }

}
