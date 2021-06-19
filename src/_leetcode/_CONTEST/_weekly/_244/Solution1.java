package _leetcode._CONTEST._weekly._244;

/**
 * @Description: 5776. 判断矩阵经轮转后是否一致
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 * @Created by: matreeix
 * @Date: 2021/6/6
 */
public class Solution1 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        // 最多旋转 4 次
        for (int k = 0; k < 4; ++k) {
            // 旋转操作
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < (n + 1) / 2; ++j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }
            }
            if (isEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i][j] != arr2[i][j])
                    return false;
            }
        }
        return true;
    }

}
