package _leetcode._CONTEST._weekly._246;

/**
 * @Description: 5791. 统计子岛屿
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * 请你返回 grid2 中 子岛屿 的 数目 。
 * @Created by: matreeix
 * @Date: 2021/6/21
 */
public class Solution3 {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;
    private boolean flag;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    dfs(i, j, grid1, grid2);
                    if (!flag) {
                        res++;
                    } else {
                        flag = false;
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, int[][] grid1, int[][] grid2) {
        grid2[x][y] = 0;
        if (grid1[x][y] == 0) flag = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (inArea(newX, newY) && grid2[newX][newY] == 1) {
                dfs(newX, newY, grid1, grid2);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(s.countSubIslands(grid1, grid2));
    }

}
