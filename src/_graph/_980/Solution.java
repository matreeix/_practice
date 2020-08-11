package _graph._980;

/**
 * @Description:不同路径Ⅲ(哈密尔顿路径)
 *
 * 在二维网格 grid 上，有 4 种类型的方格：
 *
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-iii
 *
 * @Author: caffebaby
 * @Date: 2020/2/8
 */
public class Solution {
    /**
     * 时间复杂度O(n!)
     * */

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R, C;
    private int[][] grid;
    private boolean[][] visited;
    private int start, end;

    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R][C];
        int left = R * C;

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (grid[i][j] == 1) {
                    start = i * C + j;
                    grid[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    end = i * C + j;
                    grid[i][j] = 0;
                } else if (grid[i][j] == -1)
                    left--;

        return dfs(start, left);
    }

    private int dfs(int v, int left) {

        int x = v / C, y = v % C;
        visited[x][y] = true;
        left--;
        if (v == end && left == 0) {
            visited[x][y] = false;
            return 1;
        }

        int res = 0;
        for (int d = 0; d < 4; d++) {
            int nextx = x + dirs[d][0], nexty = y + dirs[d][1];
            if (inArea(nextx, nexty) && grid[nextx][nexty] == 0 && !visited[nextx][nexty])
                res += dfs(nextx * C + nexty, left);
        }

        visited[x][y] = false;
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}
