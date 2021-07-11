package _leetcode._CONTEST._biweekly._56;

import javafx.util.Pair;
import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 5793. 迷宫中离入口最近的出口
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 * <p>
 * 提示：
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] 要么是 '.' ，要么是 '+' 。
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance 一定是空格子。
 * @Date: 2021/7/10
 */

public class Solution2 {

    public int nearestExit(char[][] maze, int[] s) {
        Queue<int[]> q = new LinkedList<>();
        int r = 1, dirs[] = {-1, 0, 1, 0, -1}, n = maze.length, m = maze[0].length;
        q.add(s);
        maze[s[0]][s[1]] = '+';
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--)
                for (int d = 1, p[] = q.poll(); d < dirs.length; d++) {
                    int x = p[0] + dirs[d - 1], y = p[1] + dirs[d];
                    if (0 <= x && x < n && 0 <= y && y < m && maze[x][y] == '.') {
                        if (x == 0 || x == n - 1 || y == 0 || y == m - 1)
                            return r;
                        maze[x][y] = '+';
                        q.add(new int[]{x, y});
                    }
                }
            r++;
        }
        return -1;
    }

    private int[] dir = {0, -1, 0, 1, 0};

    public int nearestExit2(char[][] maze, int[] ent) {
        Queue<int[]> q = new LinkedList<>(); // i, j, steps
        q.add(new int[]{ent[0], ent[1], 0});
        maze[ent[0]][ent[1]] = '+';
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int i = tmp[0], j = tmp[1], steps = tmp[2];
            if ((i != ent[0] || j != ent[1]) && (i == 0 || j == 0 || i == maze.length - 1 || j == maze[i].length-1))
                return steps;
            for (int d = 0; d < 4; ++d) {
                int di = i + dir[d], dj = j + dir[d + 1];
                if (di >= 0 && dj >= 0 && di < maze.length && dj < maze[di].length && maze[di][dj] == '.') {
                    maze[di][dj] = '+';
                    q.add(new int[]{di, dj, steps + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
//        char[][] maze = {{'.', '+'}};
        int[] enter = {1, 0};
        System.out.println((new Solution2()).nearestExit2(maze, enter));
    }
}

