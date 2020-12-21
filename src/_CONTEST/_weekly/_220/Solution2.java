package _CONTEST._weekly._220;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 1695. 删除子数组的最大得分
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * @Author: matreeix
 * @Date: 2020/12/21
 */

public class Solution2 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, sum = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                max = Math.max(sum, max);
            } else {
                while (nums[i] != nums[start]) {
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        return max;
    }
}
