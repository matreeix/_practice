package _leetcode._array._1493;

/**
 * @Description: 删除一个元素后只含有1的最长子数组
 * <p>
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 * @Author: matreeix
 * @Date: 2020/7/6
 */

public class Solution {
    //滑动窗口，窗口伸缩
    public int longestSubarray(int[] A) {
        int i = 0, j, k = 1, res = 0;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) k--;//移动右窗口
            while (k < 0) {
                if (A[i] == 0) k++;
                i++;//移动左窗口
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    //窗口不会缩小
    //For each A[j], try to find the longest subarray.
    //If A[i] ~ A[j] has zeros <= 1, we continue to increment j.
    //If A[i] ~ A[j] has zeros > 1, we increment i.
    public int longestSubarray2(int[] A) {
        int i = 0, j, k = 1;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) k--;
            if (k < 0 && A[i++] == 0) k++;//妙啊！
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1};
        int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int[] nums3 = {1, 1, 1};
        int[] nums4 = {0, 0, 0};

        System.out.println((new Solution()).longestSubarray2(nums1));//3
        System.out.println((new Solution()).longestSubarray2(nums2));//5
        System.out.println((new Solution()).longestSubarray2(nums3));//2
        System.out.println((new Solution()).longestSubarray2(nums4));//0
    }
}
