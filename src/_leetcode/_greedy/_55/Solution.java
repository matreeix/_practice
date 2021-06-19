package _leetcode._greedy._55;

/**
 * @Description:跳跃游戏Ⅰ 给定一个非负整数数组，您最初位于该数组的第一个索引处。
 * 数组中的每个元素代表该位置的最大跳转长度。
 * 确定您是否能够达到最后一个索引。
 * @Author: matreeix
 * @Date: 2020/3/4
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        int maxIndex = 0;//记录当前能到达的最大索引位置

        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex)
                return false;
            maxIndex = Math.max(nums[i] + i, maxIndex);
            if (maxIndex >= nums.length - 1)//可以提前结束
                return true;
        }
        System.out.println("居然走完了");
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 1, 4};
        int[] arr2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(arr1));
        System.out.println(canJump(arr2));
    }
}
