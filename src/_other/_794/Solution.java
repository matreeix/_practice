package _other._794;

/**
 * @Description:
 * 当turns为1时，X移动。当turns为0时，O移动。rows存储每行中的X或O数。cols存储每列中的X或O数。
 * diag以对角线存储X或O的数量。antidiag在反对角线中存储X或O的数量。当任何值达到3时，表示X获胜。
 * 当任何值达到-3时，表示O获胜。
 * 当X获胜时，O不能再移动，所以turns必须是1.当O获胜时，X不能再移动，所以turns必须为0.最后，
 * 当我们返回时，turns必须是0或1，并且X和O不能同时获胜。
 * @Author: 67ng
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
