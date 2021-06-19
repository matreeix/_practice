package _leetcode._math._453;

import java.util.Arrays;

/**
 * @Description: 453. 最小移动次数使数组元素相等
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 * @Author: matreeix
 * @Date: 2020/9/22
 */

public class Solution {
    //数学法：将除了一个元素之外的全部元素+1，等价于将该元素-1，因为我们只对元素的相对大小感兴趣。因此，该问题简化为需要进行的减法次数。
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }

    //排序法
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

}
