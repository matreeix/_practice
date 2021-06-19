package _leetcode._Cracking_the_Coding_Interview._08._02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 面试题 08.02. 迷路的机器人
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。
 * 机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。
 * 左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * @Author: matreeix
 * @Date: 2020/8/5
 */

public class Solution {
    private int row;
    private int col;
    private boolean[][] visied;

    //DFS，有向图的拓扑排序
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new LinkedList<>();
        if (obstacleGrid.length == 0) return res;
        row = obstacleGrid.length;
        col = obstacleGrid[0].length;
        visied = new boolean[row][col];
        dfs(0, 0, obstacleGrid, res);
        return res;
    }

    private boolean dfs(int i, int j, int[][] obstacle, List<List<Integer>> res) {
        if (i >= row || j >= col || obstacle[i][j] == 1 || visied[i][j]) return false;
        visied[i][j] = true;
        res.add(Arrays.asList(i, j));
        if (i == row - 1 && j == col - 1) return true;
        if (dfs(i + 1, j, obstacle, res) || dfs(i, j + 1, obstacle, res)) {
            return true;
        }
        res.remove(res.size() - 1);//当返回是false时回溯
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Solution s = new Solution();
        System.out.println(s.pathWithObstacles(arr));
    }
}
