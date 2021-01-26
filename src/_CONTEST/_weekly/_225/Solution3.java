package _CONTEST._weekly._225;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 5663. 找出第 K 大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * @Date: 2021/1/24
 */

public class Solution3 {

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) matrix[i][j] = matrix[i][j];
                else if (i == 0) matrix[i][j] = matrix[i][j - 1] ^ matrix[i][j];
                else if (j == 0) matrix[i][j] = matrix[i - 1][j] ^ matrix[i][j];
                else matrix[i][j] = matrix[i][j - 1] ^ matrix[i - 1][j] ^ matrix[i - 1][j - 1] ^ matrix[i][j];
                if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                } else {
                    if (matrix[i][j] > pq.peek()) {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }

    public int kthLargestValue2(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int[][] mat = new int[n][m];
        int[] list = new int[n*m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                mat[i][j] = matrix[i][j];
                if(i > 0)mat[i][j] ^= mat[i-1][j];
                if(j > 0)mat[i][j] ^= mat[i][j-1];
                if(i > 0 && j > 0)mat[i][j] ^= mat[i-1][j-1];
                list[i*m+j] = mat[i][j];
            }
        }
        Arrays.sort(list);
        return list[n*m-k];
    }
}
