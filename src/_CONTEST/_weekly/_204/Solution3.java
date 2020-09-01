package _CONTEST._weekly._204;

/**
 * @Description: 5501. 使陆地分离的最少天数
 * 给你一个由若干 0 和 1 组成的二维网格 grid ，其中 0 表示水，而 1 表示陆地。岛屿由水平方向或竖直方向上相邻的 1 （陆地）连接形成。
 * 如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。
 * 一天内，可以将任何单个陆地单元（1）更改为水单元（0）。
 * <p>
 * 返回使陆地分离的最少天数。
 * @Author: matreeix
 * @Date: 2020/8/30
 */

public class Solution3 {
    //核心原理：最多只需两天即可分离陆地
    public int minDays(int[][] grid) {
        if (noOfIsland(grid) != 1) {//没有陆地
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {//尝试将每块陆地变成水看陆地是否分离
                    grid[i][j] = 0;
                    if (noOfIsland(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    //统计岛的数目
    private int noOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return ans;
    }

    //遍历所有相连的陆地
    private void dfs(boolean[][] visited, int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        dfs(visited, grid, i - 1, j);
        dfs(visited, grid, i + 1, j);
        dfs(visited, grid, i, j - 1);
        dfs(visited, grid, i, j + 1);
    }

}
