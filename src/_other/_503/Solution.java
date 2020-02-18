package _other._503;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 在循环数组中找每个元素的下一个更大元素，没有就填-1
 * @Author: LeetCode@yuxiangmusic
 * @Date: 2019/8/16 20:39
 */
public class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); //单调索引栈
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];//拼接复制的数组，妙啊！
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);//索引压栈
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

}






















