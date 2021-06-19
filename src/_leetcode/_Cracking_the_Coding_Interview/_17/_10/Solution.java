package _leetcode._Cracking_the_Coding_Interview._17._10;

/**
 * @Description: 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 * @Author: matreeix
 * @Date: 2020/12/16
 */

public class Solution {
    //摩尔投票算法
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        // 验证是否满足要求
        int t = nums.length / 2 + 1;
        count = 0;
        for (int num : nums) {
            if (num == candidate)
                count++;
            if (count == t)
                return candidate;
        }
        return -1;
    }
}
