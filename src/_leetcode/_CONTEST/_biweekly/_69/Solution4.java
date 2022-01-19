package _leetcode._CONTEST._biweekly._69;

/**
 * @Description: 5931. 用邮票贴满网格图
 * 给你一个 m x n 的二进制矩阵 grid ，每个格子要么为 0 （空）要么为 1 （被占据）。
 * 给你邮票的尺寸为 stampHeight x stampWidth 。我们想将邮票贴进二进制矩阵中，且满足以下 限制 和 要求 ：
 * 1.覆盖所有 空 格子。
 * 2.不覆盖任何 被占据 的格子。
 * 3.我们可以放入任意数目的邮票。
 * 4.邮票可以相互有 重叠 部分。
 * 5.邮票不允许 旋转 。
 * 6.邮票必须完全在矩阵 内 。
 * 如果在满足上述要求的前提下，可以放入邮票，请返回 true ，否则返回 false 。
 * 提示：
 * m == grid.length
 * n == grid[r].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 2 * 10^5
 * grid[r][c] 要么是 0 ，要么是 1 。
 * 1 <= stampHeight, stampWidth <= 10^5
 * @Date: 2022/1/8
 */

public class Solution4 {
    public boolean possibleToStamp(int[][] M, int h, int w) {
        int m = M.length, n = M[0].length;
        int[][] A = new int[m + 1][n + 1];// A[i][j] means the total empty points in the rectangle
        int[][] B = new int[m + 1][n + 1];// B[i][j] means the sub-martix is all empty
        int[][] good = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i + 1][j + 1] = A[i + 1][j] + A[i][j + 1] - A[i][j] + (1 - M[i][j]);
                if (i + 1 >= h && j + 1 >= w) {
                    int x = i + 1 - h, y = j + 1 - w;
                    if (A[i + 1][j + 1] - A[x][j + 1] - A[i + 1][y] + A[x][y] == w * h)
                        good[i][j]++;
                }
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                B[i + 1][j + 1] = B[i + 1][j] + B[i][j + 1] - B[i][j] + good[i][j];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = Math.min(i + h, m), y = Math.min(j + w, n);
                if (M[i][j] == 0 && B[x][y] - B[i][y] - B[x][j] + B[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
