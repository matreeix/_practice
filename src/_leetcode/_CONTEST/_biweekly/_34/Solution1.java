package _leetcode._CONTEST._biweekly._34;

/**
 * @Description: 5491. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * @Author: matreeix
 * @Date: 2020/9/5
 */

public class Solution1 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];
        int res = 0;
        //主对角线
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
        }
        //副对角线
        for (int i = 0; i < n; i++) {
            res += mat[n - 1 - i][i];
        }
        return n % 2 == 0 ? res : res - mat[n / 2][n / 2];
    }

}
