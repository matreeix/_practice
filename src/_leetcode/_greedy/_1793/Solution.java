package _leetcode._greedy._1793;

/**
 * @Description: 1793. 好子数组的最大分数
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 * 请你返回 好 子数组的最大可能 分数 。
 * @Date: 2021/3/14
 */

public class Solution {
    public int maximumScore(int[] A, int k) {
        int res = A[k], mini = A[k], i = k, j = k, n = A.length;
        while (i > 0 || j < n - 1) {
            if (i == 0)
                ++j;
            else if (j == n - 1)
                --i;
            else if (A[i - 1] < A[j + 1])
                ++j;
            else
                --i;
            mini = Math.min(mini, Math.min(A[i], A[j]));
            res = Math.max(res, mini * (j - i + 1));
        }
        return res;
    }
}
