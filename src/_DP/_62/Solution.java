package _DP._62;

/**
 * @Description: 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @Author: Pythagodzilla
 * @Date: 2020/6/30
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    mem[i][j] = 1;
                else
                    mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
            }
        }
        return mem[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(2, 3));//3
        System.out.println(s.uniquePaths(7, 3));//28
    }
}
