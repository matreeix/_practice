package _stack._85;

import java.util.Stack;

/**
 * @Description: 85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @Author: Pythagodzilla
 * @Date: 2020/7/29
 */

public class Solution {
    //动态规划，O(N^2*M)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];//记录第i行，以(i,j)结尾的最长不含0区间长度

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxarea;
    }

    // Get the maximum area in a histogram given its heights
    public int leetcode84(int[] heights) {
        Stack< Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

    //单调栈
    public int maximalRectangle2(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                dp[j] = chars[j] == '1' ? dp[j] + 1 : 0;
            maxarea = Math.max(maxarea, leetcode84(dp));
        }
        return maxarea;
    }
}
