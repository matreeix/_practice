package _DP._63;

/**
 * @Description: 不同路径II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100
 * @Author: caffebaby
 * @Date: 2020/7/18
 */

public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;//起点或终点是障碍物

        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++)//初始化第一列
            if (obstacleGrid[i][0] == 0) mem[i][0] = 1;
            else break;

        for (int i = 0; i < n; i++)//初始化第一行
            if (obstacleGrid[0][i] == 0) mem[0][i] = 1;
            else break;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)//非障碍的地方才赋值
                    mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
            }
        }
        return mem[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
