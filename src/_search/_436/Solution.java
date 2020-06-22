package _search._436;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Pythagodzilla
 * @Date: 2020/6/22
 */

public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len == 0)
            return new int[0];

        int[] sort = new int[len];
        int[] res = new int[len];
        Map<Integer, Integer> hashMap = new HashMap<>(len);

        for (int i = 0; i < len; i++) {
            hashMap.put(intervals[i][0], i);
            sort[i] = intervals[i][0];
        }

        Arrays.sort(sort);

        for (int i = 0; i < len; i++) {
            int index = binarySearch(sort, intervals[i][1]);
            if (index == -1)
                res[i] = -1;
            else
                res[i] = hashMap.get(sort[index]);

        }
        return res;
    }

    //查找第 1 个大于等于 target 的元素的索引
    private int binarySearch(int[] arr, int target) {
        int len = arr.length;
        // 特判
        if (arr[len - 1] < target) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] ints = {{3, 4}, {2, 3}, {1, 2}};
        System.out.println(Arrays.toString((new Solution()).findRightInterval(ints)));
    }
}
