package _leetcode._graph._130;

/**
 * @Description: 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * @Date: 2021/4/5
 */

public class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i * j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    board[i][j] = 'A';
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'A')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        for (int k = 0; k < dirs.length; k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if (0 <= x && x < m && 0 <= y && y < n && board[x][y] == 'O') {
                board[x][y] = 'A';
                dfs(x, y, board);
            }
        }
    }

}
