package _leetcode._search._719;

import java.util.Arrays;

/**
 * @Description: 719. 找出第 k 小的距离对
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 * 提示:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * @Date: 2021/12/1
 */

public class Solution {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, r = nums[n - 1] - nums[0], l = r;
        for (int i = 1; i < nums.length; i++) {
            l = Math.min(nums[i] - nums[i - 1], l);
        }

        for (int cnt = 0; l < r; cnt = 0) {
            int mid = (l + r) / 2;
            for (int i = 0, j = 0; j < n; j++) { // 从小到大
                while (nums[j] - nums[i] > mid) i++;
                cnt += (j - i);
            }
            // 等效，从大到小
//            for (int i = n - 1, j = n - 1; j >= 0; j--) {
//                while (nums[i] - nums[j] > mid) i--;
//                cnt += (i - j);
//            }

            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 1};
        int k = 3;
        System.out.println(smallestDistancePair(arr, k));
    }
}
