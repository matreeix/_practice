package _array._661;

/**
 * @Description: 661. 图片平滑器
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * 注意:
 * <p>
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 * @Date: 2021/3/28
 */

public class Solution {
    //暴力解法
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr)
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }

    //bit位存储值，节省空间
    //数组的范围为[0，255]，因此仅使用尾8位，我们可以使用中间的8位存储新状态（平均值），替换为通过将所有值向右移动8位，将旧状态更改为新状态。
    public int[][] imageSmoother2(int[][] M) {
        // in-place solution
        int m = M.length, n = M[0].length;
        if (m == 0 || n == 0) return new int[0][0];
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int sum = M[i][j], cnt = 1;
                for (int k = 0; k < dirs.length; ++k) {
                    int x = i + dirs[k][0], y = j + dirs[k][1];
                    if (x < 0 || x > m - 1 || y < 0 || y > n - 1) continue;
                    sum += (M[x][y] & 0xFF);
                    cnt++;
                }
                M[i][j] |= ((sum / cnt) << 8);
            }

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                M[i][j] >>= 8;
        return M;
    }

    public static void main(String[] args) {
        System.out.println(0xFF);
    }
}
