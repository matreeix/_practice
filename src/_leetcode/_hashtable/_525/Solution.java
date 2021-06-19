package _leetcode._hashtable._525;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 525. 连续数组
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 * 注意: 给定的二进制数组的长度不会超过50000。
 * @Author: matreeix
 * @Date: 2020/10/3
 */

public class Solution {
    //前缀和+哈希表
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//<前缀和，最后的索引>
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count))
                maxlen = Math.max(maxlen, i - map.get(count));
            else
                map.put(count, i);
        }
        return maxlen;
    }

    //数组实现
    public int findMaxLength2(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }
}
