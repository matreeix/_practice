package _leetcode._CONTEST._weekly._275;


/**
 * @Description: 5977. 最少交换次数来组合所有的 1 II
 * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
 * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
 * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 为 0 或者 1
 * @Date: 2022/1/9
 */

public class Solution2 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int num : nums) cnt += num;
        if (cnt == 0) return 0;
        int cur = 0;
        for (int i = 0; i < cnt; ++i) cur += (1 - nums[i]);
        int ans = cur;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] == 0) --cur;
            if (nums[(i + cnt - 1) % n] == 0) ++cur;
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
