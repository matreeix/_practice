package _CONTEST._weekly._204;

/**
 * @Description: 5500. 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 * @Author: matreeix
 * @Date: 2020/8/30
 */

public class Solution2 {

    public static int getMaxLen(int[] nums) {
        int n = nums.length;
        int l = -1, r = 0, ll = -1, rr = -1;
        int cnt = 0;//统计负数的个数
        int len = 0;//统计长度
        while (r < n) {
            while (r < n && nums[r] != 0) {
                if (ll < 0 && nums[r] < 0) ll = r;//记录区间里第一个负数的索引
                if (nums[r] < 0) {
                    rr = r;//记录区间里最后一个负数的索引
                    cnt++;
                }
                r++;
            }
            //结算一次区间
            if (cnt % 2 == 0) {
                len = Math.max(len, r - l - 1);
            } else {
                len = Math.max(len, Math.max(rr - l - 1, r - ll - 1));
            }
            l = r;
            ll = -1;
            cnt = 0;
            r++;
        }
        return len;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, -2, -3, 4};
        int[] nums2 = {0, 1, -2, -3, -4};
        int[] nums3 = {-1, -2, -3, 0, 1};

        System.out.println(getMaxLen(nums1));//4
        System.out.println(getMaxLen(nums2));//3
        System.out.println(getMaxLen(nums3));//2

    }
}
