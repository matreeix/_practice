package _CONTEST._weekly._224;

import java.util.Arrays;

/**
 * @Description: 5655. 重新排列后的最大子矩阵
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
 * @Date: 2021/1/17
 */

public class Solution3 {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    //记录向上连续1的个数
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);
            for (int j = m - 1; j >= 0; j--) {
                //更新矩形的最大高度
                int height = matrix[i][j];
                //更新最大面积
                res = Math.max(res, height * (m - j));
            }
        }
        return res;
    }

}





















