package _leetcode._math._794;

/**
 * @Description:794. 有效的井字游戏
 * 用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 * 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
 * 以下是井字游戏的规则：
 *
 * 1.玩家轮流将字符放入空位（" "）中。
 * 2.第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
 * 3.“X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 4.当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 5.当所有位置非空时，也算为游戏结束。
 * 6.如果游戏结束，玩家不允许再放置字符。
 * @Author: matreeix
 * @Date: 2019/8/24 22:12
 */
public class Solution {
    public boolean validTicTacToe(String[] board) {
        int turns = 0;
        boolean xwin = false;
        boolean owin = false;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++;
                    rows[i]++;
                    cols[j]++;
                    if (i == j) diag++;
                    if (i + j == 2) antidiag++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--;
                    rows[i]--;
                    cols[j]--;
                    if (i == j) diag--;
                    if (i + j == 2) antidiag--;
                }
            }
        }

        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                diag == 3 || antidiag == 3;
        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                diag == -3 || antidiag == -3;

        if (xwin && turns == 0 || owin && turns == 1) {
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);

    }

}
