package _leetcode._CONTEST._biweekly._58;


/**
 * @Description: 5827. 检查操作是否合法
 * 给你一个下标从 0 开始的 8 x 8 网格 board ，其中 board[r][c] 表示游戏棋盘上的格子 (r, c) 。棋盘上空格用 '.' 表示，白色格子用 'W' 表示，黑色格子用 'B' 表示。
 * 游戏中每次操作步骤为：选择一个空格子，将它变成你正在执行的颜色（要么白色，要么黑色）。但是，合法 操作必须满足：涂色后这个格子是 好线段的一个端点 （好线段可以是水平的，竖直的或者是对角线）。
 * 好线段 指的是一个包含 三个或者更多格子（包含端点格子）的线段，线段两个端点格子为 同一种颜色 ，且中间剩余格子的颜色都为 另一种颜色 （线段上不能有任何空格子）。你可以在下图找到好线段的例子：
 * 给你两个整数 rMove 和 cMove 以及一个字符 color ，表示你正在执行操作的颜色（白或者黑），如果将格子 (rMove, cMove) 变成颜色 color 后，是一个 合法 操作，那么返回 true ，如果不是合法操作返回 false 。
 * 提示：
 * board.length == board[r].length == 8
 * 0 <= rMove, cMove < 8
 * board[rMove][cMove] == '.'
 * color 要么是 'B' 要么是 'W' 。
 * @Date: 2021/8/7
 */

public class Solution2 {

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char mark = color == 'W' ? 'B' : 'W';
        for (int i = 0; i < dirs.length; i++) {
            int r = rMove + dirs[i][0];
            int c = cMove + dirs[i][1];
            if (inArea(r, c) && board[r][c] == mark) {
                while (inArea(r, c)) {
                    r += dirs[i][0];
                    c += dirs[i][1];
                    if (inArea(r, c) && board[r][c] == '.')
                        break;
                    if (inArea(r, c) && board[r][c] == color)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return 0 <= x && x < 8 && 0 <= y && y < 8;
    }

    public static void main(String[] args) {
        char[][] boards = {{'W', 'W', '.', 'B', '.', 'B', 'B', '.'},
                            {'W', 'B', '.', '.', 'W', 'B', '.', '.'},
                            {'B', 'B', 'B', 'B', 'W', 'W', 'B', '.'},
                            {'W', 'B', '.', '.', 'B', 'B', 'B', '.'},
                            {'W', 'W', 'B', '.', 'W', '.', 'B', 'B'},
                            {'B', '.', 'B', 'W', '.', 'B', '.', '.'},
                            {'.', 'B', 'B', 'W', 'B', 'B', '.', '.'},
                            {'B', 'B', 'W', '.', '.', 'B', '.', '.'}};


        Solution2 s = new Solution2();
        System.out.println(s.checkMove(boards, 7, 4, 'B'));
    }
}
