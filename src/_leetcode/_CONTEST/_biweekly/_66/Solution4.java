package _leetcode._CONTEST._biweekly._66;

/**
 * @Description: 5925. 统计农场中肥沃金字塔的数目
 * 有一个 矩形网格 状的农场，划分为 m 行 n 列的单元格。每个格子要么是 肥沃的 （用 1 表示），要么是 贫瘠 的（用 0 表示）。网格图以外的所有与格子都视为贫瘠的。
 * 农场中的 金字塔 区域定义如下：
 * 区域内格子数目 大于 1 且所有格子都是 肥沃的 。
 * 金字塔 顶端 是这个金字塔 最上方 的格子。金字塔的高度是它所覆盖的行数。令 (r, c) 为金字塔的顶端且高度为 h ，那么金字塔区域内包含的任一格子 (i, j)
 * 需满足 r <= i <= r + h - 1 且 c - (i - r) <= j <= c + (i - r) 。
 * 一个 倒金字塔 类似定义如下：
 * 区域内格子数目 大于 1 且所有格子都是 肥沃的 。
 * 倒金字塔的 顶端 是这个倒金字塔 最下方 的格子。倒金字塔的高度是它所覆盖的行数。令 (r, c) 为金字塔的顶端且高度为 h ，那么金字塔区域内包含的任一格子 (i, j)
 * 需满足 r - h + 1 <= i <= r 且 c - (r - i) <= j <= c + (r - i) 。
 * 下图展示了部分符合定义和不符合定义的金字塔区域。黑色区域表示肥沃的格子。
 * 给你一个下标从 0 开始且大小为 m x n 的二进制矩阵 grid ，它表示农场，请你返回 grid 中金字塔和倒金字塔的 总数目 。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 10^5
 * grid[i][j] 要么是 0 ，要么是 1 。
 * @Date: 2021/11/28
 */

public class Solution4 {
    public static int m;
    public static int n;

    // 时间复杂度 O(mnH^3)
    public int countPyramids(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int H = Math.min(m, (n + 1) / 2);// 金字塔的最大高度

        int res = 0;
        for (int h = 2; h <= H; h++) {// 遍历高度 O(min(m,n))
            for (int i = 0; i < grid.length; i++) {// O(m)
                for (int j = 0; j < grid[0].length; j++) {// O(n)
                    if (grid[i][j] == 1) {// 遍历顶点
                        // 正金字塔
                        boolean isPyramid = true, loop1 = true, loop2 = true;
                        // O(h^2)
                        for (int x = i; x <= i + h - 1 && loop1; x++) {// r <= i <= r + h - 1
                            for (int y = j - (x - i); y <= j + (x - i) && loop2; y++) {// c - (i - r) <= j <= c + (i - r)
                                if (!inArea(x, y) || grid[x][y] == 0) {
                                    isPyramid = false;
                                    loop1 = false;
                                    loop2 = false;
                                }
                            }
                        }
                        if (isPyramid) res++;
                        // 倒金字塔
                        isPyramid = true;
                        loop1 = true;
                        loop2 = true;
                        for (int x = i - h + 1; x <= i && loop1; x++) {// r - h + 1 <= i <= r
                            for (int y = j - (i - x); y <= j + (i - x) && loop2; y++) {// c - (r - i) <= j <= c + (r - i)
                                if (!inArea(x, y) || grid[x][y] == 0) {
                                    isPyramid = false;
                                    loop1 = false;
                                    loop2 = false;
                                }
                            }
                        }
                        if (isPyramid) res++;
                    }
                }
            }
        }
        return res;
    }

    public boolean inArea(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 0, 0, 1}};
        System.out.println((new Solution4()).countPyramids(grid));
    }
}
