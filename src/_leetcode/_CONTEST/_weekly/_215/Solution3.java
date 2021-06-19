package _leetcode._CONTEST._weekly._215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1658. 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 * @Author: matreeix
 * @Date: 2020/11/21
 */

public class Solution3 {
    public int minOperations(int[] nums, int x) {
        // 使用滑动窗口找中间最长的片段使得sum(片段)=sum(nums)-x
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int currentSum = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (left < n) {
            // 如果右边未到尽头，不断先向右探测片段，如果大于目标sum-x则左边移动直到结束
            if (right < n) {
                currentSum += nums[right++];
            }
            while (currentSum > sum - x && left < n) {
                currentSum -= nums[left++];
            }
            if (currentSum == sum - x) {
                maxPart = Math.max(maxPart, right - left);
            }
            if (right == n) {
                left++;
            }
        }
        return maxPart == -1 ? -1 : n - maxPart;
    }

    public int minOperations2(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;

        if (target == 0) return nums.length;  // since all elements are positive, we have to take all of them

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }

            // no need to check containsKey since sum is unique
            map.put(sum, i);
        }

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

    public int minOperations3(int[] nums, int x) {
        int target = 0;
        for (int n : nums) target += n;
        if (target < x) return -1;
        if (target == x) return nums.length;
        target -= x;
        int len = -1;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            target -= nums[i];
            while (target < 0) {
                target += nums[j++];
            }
            if (target == 0) len = Math.max(len, (i - j + 1));
        }
        return len == -1 ? -1 : nums.length - len;
    }
}
