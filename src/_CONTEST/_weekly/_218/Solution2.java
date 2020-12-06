package _CONTEST._weekly._218;

import java.util.Arrays;

/**
 * @Description: 5618. K 和数对的最大数目
 * 给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 * @Author: matreeix
 * @Date: 2020/12/6
 */

public class Solution2 {
    public int maxOperations(int[] nums, int k) {
        int res = 0, i = 0, j = nums.length - 1;
        if (j == 0) return res;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                res++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            }else {
                j--;
            }
        }
        return res;

    }
}
