package _leetcode._Cracking_the_Coding_Interview._01._07;

import java.util.Arrays;

/**
 * @Description: 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 * @Author: matreeix
 * @Date: 2020/7/31
 */

public class Solution {
    //原地旋转
    public static void rotate(int[][] matrix) {
        if (matrix.length <= 1) return;
        int n = matrix.length;
        for (int j = 0; j < n / 2; j++) {
            for (int i = j; i < n - 1 - j; i++) {
                int tmp = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = matrix[j][i];
                matrix[j][i] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }
    }

    //两次翻转代替旋转
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                swap(matrix, i, j, n - i - 1, j);
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j, int m, int n) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = tmp;
    }

    //9,4,7  7,4,1
    //8,5,2  8,5,2
    //3,6,1  9,6,3
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

}
