package _999;

/**
 * @Description: 二维数组中，R在同竖行或横行找邻近第一个字母是p的个数
 * @Author: 67ng
 * @Date: 2019/7/25 20:50
 */
public class Solution {
    public static int nudRookCaptures(char[][] board) {
        int count = 0;
        int X = 0;
        int Y = 0;
        //遍历找到R的坐标
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    X = i;
                    Y = j;
                }
            }
        }

        //匹配能否找到P


        //朝右找
        for (int r = Y + 1; r < board.length; r++) {
            if (board[X][r] == 'P') {
                count++;
                r = board.length - 1;
            }
            if (board[X][r] == 'B') {
                r = board.length - 1;
            }
        }

        //朝左找
        for (int l = Y - 1; l > -1; l--) {
            if (board[X][l] == 'P') {
                count++;
                l = 0;
            }
            if (board[X][l] == 'B') {
                l = 0;
            }
        }

        //朝下找
        for (int d = X + 1; d < board.length; d++) {
            if (board[d][Y] == 'P') {
                count++;
                d = board.length - 1;
            }
            if (board[d][Y] == 'B') {
                d = board.length - 1;
            }
        }

        //朝上找
        for (int u = X - 1; u > -1; u--) {
            if (board[u][Y] == 'P') {
                count++;
                u = 0;
            }
            if (board[u][Y] == 'B') {
                u = 0;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        char[][] strings = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'P', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'P'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'P', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println(nudRookCaptures(strings));
    }

}
