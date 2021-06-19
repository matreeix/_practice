package _leetcode._array._59;

import java.util.Arrays;

/**
 * @Description: 螺旋矩阵II
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 扩展：矩阵为 n*m时，怎么构造？
 * @Author: matreeix
 * @Date: 2020/5/24
 */
public class Solution {
    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++)
                mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++)
                mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--)
                mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--)
                mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

    public static int[][] generateMatrix(int n, int m) {
        int[][] res = new int[n][m];

        //方向数组的顺序很重要，和下面的取模对应着看
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int x = 0, y = 0, k = 1, d = 0; k <= n * m; k++) {
            res[x][y] = k;
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || res[nx][ny] != 0) {
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
        System.out.println(Arrays.deepToString(generateMatrix(3, 3)));
    }


}
