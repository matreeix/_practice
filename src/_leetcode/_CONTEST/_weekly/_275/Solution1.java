package _leetcode._CONTEST._weekly._275;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 5976. 检查是否每一行每一列都包含全部整数
 * 对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。
 * 给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。
 * @Date: 2022/1/9
 */

public class Solution1 {
    public boolean checkValid(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[i][j] = matrix[j][i];
            }
        }

        for (int[] ints : matrix)
            if (!isValid(ints))
                return false;
        for (int[] ints : copy)
            if (!isValid(ints))
                return false;
        return true;
    }

    private boolean isValid(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i : arr) {
            if (tmp[i - 1] != 0)
                return false;
            tmp[i - 1] = i;
        }
        return true;
    }

    //哈希表
    public boolean checkValid2(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; ++r) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int c = 0; c < n; ++c) {
                if(!row.add(matrix[r][c])) return false;
                if(!col.add(matrix[c][r])) return false;
            }
        }
        return true;
    }
}
