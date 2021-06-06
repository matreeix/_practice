package _CONTEST._weekly._244;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description: 5777. 使数组元素相等的减少操作次数
 * 给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤：
 * 1.找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。
 * 2.找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。
 * 3.将 nums[i] 减少到 nextLargest 。
 * 返回使 nums 中的所有元素相等的操作次数。
 * @Created by: matreeix
 * @Date: 2021/6/6
 */
public class Solution2 {
    public static int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int[] cnt = new int[map.size()];
        int idx = 0;
        for (int val : map.values())
            cnt[idx++] = val;
        int res = 0;
        for (int i = cnt.length - 1; i >= 1; i--) {
            res += cnt[i] * i;
        }
        return res;
    }

    public int reductionOperations2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int cnt = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                ++cnt;
            }
            res += cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        System.out.println(reductionOperations(nums));
    }
}
