package _array._289;

import java.util.Arrays;

/**
 * @Description: 生命游戏
 * 以自己为中心，其余八个元素为邻居，1为存活，0为死亡
 * 1.num(1)<2,则1->0
 * 2.num(1)==2||3,则1->1
 * 3.num(1)>3,则1->0
 * 4.num(1)==3,则0->1
 * @Author: yavinci
 * @Date: 2019/12/28 21:53
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;//行
        int n = board[0].length;//列

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);
                //第二状态位初始时都为零，所以只需考虑何时会变1的情况
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        //通过右移一位得到第二状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    //得到坐标为(i,j)的存活的邻居数，m、n分别为行和列的长度，是边界条件
    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        //循环九宫格得到所有为1的存活数
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {//行数
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {//列数
                lives += board[x][y] & 1;
            }
        }
        return lives - board[i][j];//上面循环时把本身算进去了，所以要减掉自己
    }


    public static void main(String[] args) {
        int[][] ints = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
             };
        Solution solution = new Solution();
        solution.gameOfLife(ints);
        System.out.println(Arrays.deepToString(ints));
    }
}



