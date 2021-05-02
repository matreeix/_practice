package _array._724;

/**
 * @Description: 724. 寻找数组的中心下标
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * 注意：中心下标可能出现在数组的两端。
 * <p>
 * 提示：
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * @Created by: matreeix
 * @Date: 2021/5/2
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 0;
        int[] pre = new int[n];//前缀和数组
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + nums[i];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l = i == 0 ? 0 : pre[i - 1];
            r = pre[n - 1] - pre[i];
            if (l == r)
                return i;
        }
        return -1;
    }

}
