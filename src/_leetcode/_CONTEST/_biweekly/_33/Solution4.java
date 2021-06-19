package _leetcode._CONTEST._biweekly._33;

/**
 * @Description: 5482. 二维网格图中探测环
 * 给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
 * 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。
 * 同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。
 * 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
 * @Author: matreeix
 * @Date: 2020/8/22
 */

public class Solution4 {
    private boolean[][] visited;
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (m == 1 || n == 1) return false;
        visited = new boolean[m][n];
        for (int i = 0; i < m * n; i++) {
            if (!visited[i / n][i % n] && dfs(i, -1, grid[i / n][i % n], grid))
                return true;
        }
        return false;
    }

    private boolean dfs(int v, int pv, char ch, char[][] grid) {
        int curx = v / n, cury = v % n;
        if (visited[curx][cury]) return true;
        else visited[curx][cury] = true;
        for (int d = 0; d < 4; d++) {
            int nextx = curx + dirs[d][0], nexty = cury + dirs[d][1];
            int next = nextx * n + nexty;
            if (inArea(nextx, nexty)
                    && next != pv
                    && grid[nextx][nexty] == ch
                    && dfs(next, v, ch, grid))
                return true;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] grid = {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
        char[][] grid2 = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        char[][] grid4 = {{'a', 'a'}, {'a', 'c'}};
        char[][] grid3 = {{'d', 'b', 'b'},
                {'c', 'a', 'a'},
                {'b', 'a', 'c'},
                {'c', 'c', 'c'},
                {'d', 'd', 'a'}};
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.containsCycle(grid));
        System.out.println(solution4.containsCycle(grid2));
        System.out.println(solution4.containsCycle(grid3));
        System.out.println(solution4.containsCycle(grid4));
//        System.out.println(Arrays.deepToString(solution4.visited));
    }
}
