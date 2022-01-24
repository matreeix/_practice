package _leetcode._CONTEST._weekly._277;

/**
 * @Description: 5991. 按符号重排数组
 * 给你一个下标从 0 开始的整数数组 nums ，数组长度为 偶数 ，由数目相等的正整数和负整数组成。
 * 你需要 重排 nums 中的元素，使修改后的数组满足下述条件：
 * 任意 连续 的两个整数 符号相反
 * 对于符号相同的所有整数，保留 它们在 nums 中的 顺序 。
 * 重排后数组以正整数开头。
 * 重排元素满足上述条件后，返回修改后的数组。
 * 提示：
 * 2 <= nums.length <= 2 * 10^5
 * nums.length 是 偶数
 * 1 <= |nums[i]| <= 10^5
 * nums 由 相等 数量的正整数和负整数组成
 * @Date: 2022/1/23
 */

public class Solution2 {
    // 奇数索引存负数，偶数索引存正数即可
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int odd = 1;
        int eve = 0;
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0) {
                res[eve] = nums[i];
                eve += 2;
            } else {
                res[odd] = nums[i];
                odd += 2;
            }
        }
        return res;
    }
}
