package _leetcode._CONTEST._weekly._254;

import java.util.Arrays;

/**
 * @Description: 5832. 构造元素不等于两相邻元素平均值的数组
 * 给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两侧相邻元素的 平均值 。
 * 更公式化的说法是，重新排列的数组应当满足这一属性：对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + nums[i+1]) / 2 不等于 nums[i] 均成立 。
 * 返回满足题意的任一重排结果。
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * @Date: 2021/8/15
 */

public class Solution2 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) res[i] = nums[l++];
            else res[i] = nums[r--];
        }
        return res;
    }
}
