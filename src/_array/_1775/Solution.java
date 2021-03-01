package _array._1775;


/**
 * @Description: 1775. 通过最少操作次数使数组的和相等
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * @Date: 2021/3/1
 */

public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int num : nums1) sum1 += num;
        for (int num : nums2) sum2 += num;
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) {//妙啊，减少了一种讨论，优化代码结构
            return minOperations(nums2, nums1);
        }

        //sum2 > sum1
        int diff = sum2 - sum1;
        int[] freq = new int[6];
        for (int num : nums1) ++freq[6 - num];
        for (int num : nums2) ++freq[num - 1];

        int ans = 0;
        for (int i = 5; i >= 1 && diff > 0; --i) {
            while (freq[i] != 0 && diff > 0) {
                ++ans;
                --freq[i];
                diff -= i;
            }
        }

        return (diff > 0 ? -1 : ans);
    }

}
