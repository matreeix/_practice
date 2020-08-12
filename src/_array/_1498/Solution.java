package _array._1498;

import java.util.Arrays;

/**
 * @Description: 满足条件的子序列数目
 * <p>
 * 给你一个整数数组 nums 和一个整数 target 。
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的和小于或等于 target 的非空子序列的数目。
 * 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
 * @Author: matreeix
 * @Date: 2020/7/5
 */

public class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] * 2 > target) return 0;
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        int mod = 1000000007;

        //细节！必须要生成这个数组，（A + B）％C =（A％C + B％C）％C
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; ++i)
            pows[i] = pows[i - 1] * 2 % mod;

        while (left <= right) {
            if (nums[left] + nums[right] > target)
                right--;
            else
                count = (count + pows[right-left++]) % mod;
        }
        return count;
    }

    public int numSubseq2(int[] A, int target) {
        Arrays.sort(A);
        int res = 0, n = A.length, l = 0, r = n - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; ++i)
            pows[i] = pows[i - 1] * 2 % mod;
        while (l <= r) {
            if (A[l] + A[r] > target) {
                r--;
            } else {
                res = (res + pows[r - l++]) % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num1 = {3, 5, 6, 7};
        int[] num2 = {3, 3, 6, 8};
        int[] num3 = {2, 3, 3, 4, 6, 7};
        int[] num4 = {1, 2, 4, 5, 6, 7, 8};
        int[] num5 = {14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14};
        int target1 = 9;
        int target2 = 10;
        int target3 = 12;
        int target4 = 16;
        int target5 = 22;

        System.out.println(s.numSubseq(num1, target1));//4
        System.out.println(s.numSubseq(num2, target2));//6
        System.out.println(s.numSubseq(num3, target3));//61
        System.out.println(s.numSubseq(num4, target4));//127
        System.out.println(s.numSubseq(num5, target5));//272187084
        System.out.println(s.numSubseq2(num5, target5));//272187084
    }
}