package _leetcode.backtracking._1219;

/**
 * @Description: 1219. 黄金矿工
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 * 提示：
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * 最多 25 个单元格中有黄金。
 *
 * @Date: 2021/12/18
 */

public class Solution {
    private int res;
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, 0);
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j, int cnt) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            res = Math.max(res, cnt);
            return;
        }

        cnt += grid[i][j];
        for (int[] dir : dirs) {
            int tmp = grid[i][j];
            grid[i][j] = 0;
            dfs(grid, i + dir[0], j + dir[1], cnt);
            grid[i][j] = tmp;
        }
    }
}
