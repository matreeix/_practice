package _Cracking_the_Coding_Interview._16._04;

/**
 * @Description: 面试题 16.04. 井字游戏
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 1.玩家轮流将字符放入空位（" "）中。
 * 2.第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * 3."X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 4.当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 5.当所有位置非空时，也算为游戏结束。
 * 6.如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * @Author: matreeix
 * @Date: 2020/10/20
 */

public class Solution {
    public static String tictactoe(String[] board) {
        boolean space = false;
        int n = board.length;
        boolean diagonal1 = false;
        boolean diagonal2 = false;

        for (int m = 0; m < 2; m++) {//0判断行，1判断列
            for (int i = 0; i < n; i++) {
                char mark = m == 0 ? board[i].charAt(0) : board[0].charAt(i);
                //判断是否有空位
                if (!space)
                    space = board[i].length() != board[i].trim().length();
                //判断行、竖
                for (int j = 0; j < n; ) {
                    char tmp = m == 0 ? board[i].charAt(j) : board[j].charAt(i);
                    if (mark != tmp) {
                        break;
                    } else {
                        j++;
                        if (j == n) {
                            return String.valueOf(mark);
                        }
                    }
                }
                //判断对角线
                if (board[0].charAt(0) != board[i].charAt(i)) {
                    diagonal1 = true;
                }
                if (board[0].charAt(n - 1) != board[i].charAt(n - 1 - i)) {
                    diagonal2 = true;
                }

            }
            if (!diagonal1 || !diagonal2) {
                return !diagonal1 ? String.valueOf(board[0].charAt(0)) : String.valueOf(board[0].charAt(n - 1));
            }
        }

        return space ? "Pending" : "Draw";
    }

    public static void main(String[] args) {
        String[] board1 = {"O X", " XO", "X O"};
        String[] board2 = {"OOX", "XXO", "OXO"};
        String[] board3 = {"OOX", "XXO", "OX "};
        String[] board4 = {"   X O  O ",
                            " X X    O ",
                            "X  X    O ",
                            "X    OX O ",
                            "X   XO  O ",
                            "X  X O  O ",
                            "O  X O  O ",
                            "     O  OX",
                            "     O  O ",
                            "   X XXXO "};
        System.out.println(tictactoe(board1));
        System.out.println(tictactoe(board2));
        System.out.println(tictactoe(board3));
        System.out.println(tictactoe(board4));//O

    }
}
