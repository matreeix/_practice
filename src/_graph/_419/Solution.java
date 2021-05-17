package _graph._419;

/**
 * @Description: 419. 甲板上的战舰
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 * 1.给你一个有效的甲板，仅由战舰或者空位组成。
 * 2.战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 3.两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * 进阶:
 * 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？
 * @Created by: matreeix
 * @Date: 2021/5/16
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0, i, j;
        for (i = 0; i < board.length; ++i)
            for (j = 0; j < board[0].length; ++j) {
                if ((board[i][j] == 'X')
                        && (i == 0 || board[i - 1][j] == '.')
                        && (j == 0 || board[i][j - 1] == '.'))//只记录所有战舰左上角的数目即可
                    ++count;
            }
        return count;
    }
}
