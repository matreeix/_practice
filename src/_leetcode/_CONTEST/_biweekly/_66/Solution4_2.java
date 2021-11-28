package _leetcode._CONTEST._biweekly._66;

/**
 * @Description:
 * @Date: 2021/11/28
 */

public class Solution4_2 {
    public static int m;
    public static int n;

    // 前缀和优化，时间复杂度 O(mnH^2)
    public int countPyramids(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int H = Math.min(m, (n + 1) / 2);// 金字塔的最大高度
        int[][] pre = new int[m][n];
        for (int i = 0; i < pre.length; i++) {
            pre[i][0] = grid[i][0] == 1 ? 1 : 0;
            for (int j = 1; j < pre[0].length; j++) {
                pre[i][j] = pre[i][j - 1] + (grid[i][j] == 1 ? 1 : 0);
            }
        }

        int res = 0;
        for (int h = 2; h <= H; h++) {// 遍历高度 O(min(m,n))
            for (int i = 0; i < grid.length; i++) {// O(m)
                for (int j = 0; j < grid[0].length; j++) {// O(n)
                    if (grid[i][j] == 1) {// 遍历顶点
                        // 正金字塔
                        boolean isPyramid = true;
                        // O(h)
                        for (int k = 1; k < h; k++) {
                            int r = j + k, l = j - k;
                            if (!inArea(i + k, r) || !inArea(i + k, l)
                                    || pre[i + k][r] - pre[i + k][l] != r - l
                                    || grid[i + k][l] != 1) {
                                isPyramid = false;
                                break;
                            }
                        }
                        if (isPyramid) res++;
                        // 倒金字塔
                        isPyramid = true;
                        for (int k = 1; k < h; k++) {
                            int r = j + k, l = j - k;
                            if (!inArea(i - k, r) || !inArea(i - k, l)
                                    || pre[i - k][r] - pre[i - k][l] != r - l
                                    || grid[i - k][l] != 1) {
                                isPyramid = false;
                                break;
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
        System.out.println((new Solution4_2()).countPyramids(grid));
    }

}
