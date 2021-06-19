package _leetcode._CONTEST._weekly._218;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 5619. 最小不兼容性
 * 给你一个整数数组 nums​​​ 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
 * 一个子集的 不兼容性 是该子集里面最大值和最小值的差。
 * 请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
 * 子集的定义是数组中一些数字的集合，对数字顺序没有要求。
 * <p>
 * 提示：
 * 1 <= k <= nums.length <= 16
 * nums.length 能被 k 整除。
 * 1 <= nums[i] <= nums.length
 * @Author: matreeix
 * @Date: 2020/12/6
 */

public class Solution4 {
    int N;
    Map<String, Integer> memo;
    int k;

    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        int[] count = new int[17];
        for (int num : nums) if (++count[num] > k) return -1;
        N = nums.length / k;
        return dfs(0, count);
    }

    private int dfs(int level, int[] count) {
        if (Integer.bitCount(level) == N)
            if (end(count))
                return findDiff(level);
            else
                return findDiff(level) + dfs(0, count);

        String key = Arrays.hashCode(count) + " " + level;
        if (memo.containsKey(key)) return memo.get(key);
        int res = 1000;
        for (int i = 1; i <= 16; i++) {
            if (count[i] <= 0)
                continue;
            int mask = 1 << i;
            if ((level & mask) != 0)
                continue;
            level |= mask;
            count[i]--;
            res = Math.min(res, dfs(level, count));
            count[i]++;
            level ^= mask;
            if (Integer.bitCount(level) == 0)
                break;  // first element we don't need to expand
        }
        memo.put(key, res);
        return res;
    }

    //
    private int findDiff(int level) {
        int max = 0, min = 16;
        for (int i = 1; i <= 16; i++) {
            int mask = 1 << i;
            if ((level & mask) == 0)
                continue;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }

    private boolean end(int[] count) {
        for (int c : count)
            if (c != 0)
                return false;
        return true;
    }

}
