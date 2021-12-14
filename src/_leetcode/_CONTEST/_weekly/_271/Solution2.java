package _leetcode._CONTEST._weekly._271;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: 5953. 子数组范围和
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * 返回 nums 中 所有 子数组范围的 和 。
 * 子数组是数组中一个连续 非空 的元素序列。
 * 提示：
 * 1 <= nums.length <= 1000
 * -10^9 <= nums[i] <= 10^9
 * @Date: 2021/12/12
 */

public class Solution2 {
    // 单调队列，O(n^2)
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int len = 2; len <= nums.length; len++) {
            int[][] tmp = slidingWindow(nums, len);
            for (int[] arr : tmp) {
                ans += arr[0] - arr[1];
            }
        }
        return ans;
    }

    public int[][] slidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque1 = new LinkedList<Integer>();// 最大值队列
        Deque<Integer> deque2 = new LinkedList<Integer>();// 最小值队列
        for (int i = 0; i < k; ++i) {
            while (!deque1.isEmpty() && nums[i] >= nums[deque1.peekLast()]) {
                deque1.pollLast();
            }
            while (!deque2.isEmpty() && nums[i] <= nums[deque2.peekLast()]) {
                deque2.pollLast();
            }
            deque1.offerLast(i);
            deque2.offerLast(i);
        }

        int[][] ans = new int[n - k + 1][2];
        ans[0][0] = nums[deque1.peekFirst()];
        ans[0][1] = nums[deque2.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque1.isEmpty() && nums[i] >= nums[deque1.peekLast()]) {
                deque1.pollLast();
            }
            deque1.offerLast(i);
            while (deque1.peekFirst() <= i - k) {
                deque1.pollFirst();
            }
            ans[i - k + 1][0] = nums[deque1.peekFirst()];

            while (!deque2.isEmpty() && nums[i] <= nums[deque2.peekLast()]) {
                deque2.pollLast();
            }
            deque2.offerLast(i);
            while (deque2.peekFirst() <= i - k) {
                deque2.pollFirst();
            }
            ans[i - k + 1][1] = nums[deque2.peekFirst()];
        }
        return ans;
    }

    // O(n^2)
    public long subArrayRanges2(int[] A) {
        long res = 0;
        for (int i = 0; i < A.length; i++) {// 从i开始的所有子数组
            int max = A[i], min = A[i];
            for (int j = i; j < A.length; j++) {// 以j结尾的子数组
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                res += max - min;
            }
        }
        return res;
    }

    // O(n)
    public long subArrayRanges3(int[] nums) {
        int n = nums.length, j, k;
        long res = 0;

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && nums[s.peek()] > (i == n ? Integer.MIN_VALUE : nums[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long) nums[j] * (i - j) * (j - k);
            }
            s.push(i);
        }
        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && nums[s.peek()] < (i == n ? Integer.MAX_VALUE : nums[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long) nums[j] * (i - j) * (j - k);
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {4, -2, -3, 4, 1};
        int[] nums = {1, 1, 3};
        System.out.println((new Solution2()).subArrayRanges(nums));
    }
}
