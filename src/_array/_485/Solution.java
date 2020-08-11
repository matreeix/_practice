package _array._485;

import java.util.Map;

/**
 * @Description: 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * @Author: caffebaby
 * @Date: 2019/7/26 22:41
 */
public class Solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0};
        System.out.println(findMaxConsecutiveOnes(nums));//6
    }
}
