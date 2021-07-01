package _leetcode._array._498;

import java.util.Arrays;

/**
 * @Description: 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * @Date: 2021/7/1
 */

public class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int flag = 1;//1向上，-1向下
        int x = 0, y = 0;
        res[0] = mat[0][0];
        for (int i = 1; i < res.length; i++) {
            if (flag == 1) {
                x = x - 1;
                y = y + 1;
                if (inArea(x, y, m, n)) {
                    res[i] = mat[x][y];
                } else {
                    if (y < n) {
                        x += 1;
                    } else {
                        y -= 1;
                        x += 2;
                    }
                    res[i] = mat[x][y];
                    flag = -1;
                }
            } else {
                x = x + 1;
                y = y - 1;
                if (inArea(x, y, m, n)) {
                    res[i] = mat[x][y];
                } else {
                    if (x < m) {
                        y += 1;
                    } else {
                        x -= 1;
                        y += 2;
                    }
                    res[i] = mat[x][y];
                    flag = 1;
                }
            }
        }
        return res;
    }

    private boolean inArea(int x, int y, int m, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    public int[] findDiagonalOrder2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            res[k++] = mat[i][j];
            if ((i + j) % 2 == 0) {
                if (j == n - 1) {  // 最后一列，向下
                    i++;
                } else if (i == 0) { // 第一行，向右
                    j++;
                } else { // 向右上
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {  // 最后一行，向右
                    j++;
                } else if (j == 0) { // 第一列，向下
                    i++;
                } else { // 向左下
                    i++;
                    j--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(s.findDiagonalOrder(mat)));
    }
}
