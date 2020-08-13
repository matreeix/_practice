package _CONTEST._weekly._201;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 5471. 和为目标值的最大数目不重叠非空子数组数目
 * 给你一个数组 nums 和一个整数 target 。
 * <p>
 * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
 * @Author: matreeix
 * @Date: 2020/8/9
 */

public class Solution3 {

    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, endIdx = -1, res = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remain = prefixSum - target;
            if (map.containsKey(remain) && map.get(remain) >= endIdx) {
                res++;
                endIdx = i;
            }
            map.put(prefixSum, i);//记录前缀和
        }
        return res;
    }

}
