package _stack._84;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @Author: caffebaby
 * @Date: 2020/7/29
 */

public class Solution {
    //单调栈
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];//heights[i]高度向左最大延伸的索引边界
        int[] right = new int[n];//heights[i]高度向右最大延伸的索引边界
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;//当前栈顶元素的右边界是索引i
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i)
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        return ans;
    }

}
