package _CONTEST._weekly._206;


/**
 * @Description: 1582. 二进制矩阵中的特殊位置
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，
 * 请返回 矩阵 mat 中特殊位置的数目 。
 * 特殊位置定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素
 * 均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * @Author: matreeix
 * @Date: 2020/9/16
 */

public class Solution1 {
    public static int numSpecial(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial(arr));
    }
}



