package _Cracking_the_Coding_Interview._08._03;

/**
 * @Description: 面试题 08.03. 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，
 * 如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个
 * @Author: Pythagodzilla
 * @Date: 2020/8/5
 */

public class Solution {
    //间隔跳跃查找
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (i == nums[i]) return i;
            // jump as long as we can
            i = Math.max(i + 1, nums[i]);//妙啊！
        }
        return -1;
    }

    //分治，有重复元素时不能使用二分法，参考：https://leetcode-cn.com/problems/magic-index-lcci/solution/mo-zhu-suo-yin-by-leetcode-solution/
    public int findMagicIndex2(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {//先求左侧
            return leftAnswer;
        } else if (nums[mid] == mid) {//再求中间
            return mid;
        }
        return getAnswer(nums, mid + 1, right);//最后求右侧
    }

    public static void main(String[] args) {

    }
}
