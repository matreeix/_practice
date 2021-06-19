package _leetcode._array._54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 螺旋矩阵
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @Author: matreeix
 * @Date: 2020/5/24
 */
public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix == null) return res;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] mark = new boolean[n][m];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int x = 0, y = 0, k = 1, d = 0; k <= n * m; k++) {
            res.add(matrix[x][y]);
            mark[x][y] = true;
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || mark[nx][ny]) {//走到边界，即出界或者已经走过
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(arr));
    }
}
