package _leetcode._Cracking_the_Coding_Interview._17._04;

/**
 * @Description: 面试题 17.04. 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * 注意：本题相对书上原题稍作改动
 * @Author: matreeix
 * @Date: 2020/12/8
 */

public class Solution {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res ^ n;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 8, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }
}
