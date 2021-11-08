package _leetcode._CONTEST._weekly._265;

/**
 * @Description: 2057. 值相等的最小索引
 * 给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；如果不存在这样的下标，返回 -1 。
 * x mod y 表示 x 除以 y 的 余数 。
 * @Date: 2021/11/8
 */

public class Solution1 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;

    }
}
