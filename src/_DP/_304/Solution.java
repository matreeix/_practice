package _DP._304;

import java.util.Arrays;

/**
 * @Description:
 * @Author: caffebaby
 * @Date: 2020/3/17
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(Arrays.deepToString(obj.matrix));
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }

    static class NumMatrix {
        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] += matrix[0][j - 1];//为第一行赋值
            }
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] += matrix[i - 1][0];//为第一列赋值
                for (int j = 1; j < matrix[0].length; j++) {//i、j的位置可以对调，下面求和就要竖着求
                    matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1] + matrix[i][j];//其他行列赋值
                }
            }
            this.matrix = matrix;//matrix[i][j]储存了以(0,0)和(i,j)围成的矩形之和
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (col1 == 0 && row1 == 0)
                return matrix[row2][col2];
            else if (col1 == 0)
                return matrix[row2][col2] - matrix[row1 - 1][col2];
            else if (row1 == 0)
                return matrix[row2][col2] - matrix[row2][col1 - 1];
            else
                return matrix[row2][col2] - matrix[row1 - 1][col2] - matrix[row2][col1 - 1] + matrix[row1 - 1][col1 - 1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
