package _leetcode._CONTEST._weekly._277;

import java.util.Arrays;

/**
 * @Description: 5989. 元素计数
 * 给你一个整数数组 nums ，统计并返回在 nums 中同时具有一个严格较小元素和一个严格较大元素的元素数目。
 * @Date: 2022/1/23
 */

public class Solution1 {
    public int countElements(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n - 1];
        if (max == min) return 0;
        int l = 0, r = n - 1;
        while (l < n && nums[l] == min) l++;
        while (r > 0 && nums[r] == max) r--;
        return r - l + 1;
    }
}
