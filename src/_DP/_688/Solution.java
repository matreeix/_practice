package _DP._688;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 688. “马”在棋盘上的概率
 * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。
 * 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。
 * 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
 * 现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
 * 求移动结束后，“马” 仍留在棋盘上的概率
 * @Author: matreeix
 * @Date: 2020/7/31
 */

public class Solution {
    private final int[][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    //递归，LTE,p = 移动k次仍在棋盘的次数/8^k=第1次走法数*第2次走法数……第k次走法数/8^k
    public double knightProbability(int N, int K, int r, int c) {
        if (K == 0) return 1.0;
        if (N <= 2) return 0.0;

        double p = 0.0;//此次跳在棋盘的概率
        for (int i = 0; i < dirs.length; i++) {
            int x = r + dirs[i][0];
            int y = c + dirs[i][1];
            if (inArea(x, y, N))
                p += 0.125 * knightProbability(N, K - 1, x, y);
        }
        return p;
    }

    private boolean inArea(int x, int y, int N) {
        return (0 <= x && x <= N - 1) && (0 <= y && y <= N - 1);
    }

    //动态规划
    public double knightProbability2(int N, int K, int r, int c) {
        if (K == 0) return 1.0;
        if (N < 3) return 0.0;
        //f[r][c][steps] 代表马在位置 (r, c) 移动了 steps 次以后还留在棋盘上的概率
        //f[r][c][steps]=∑f[r+dr][c+dc][steps−1]/8.0
        double[][] pre = new double[N][N];//f[][][steps-1]
        pre[r][c] = 1;
        for (; K > 0; K--) {
            double[][] cur = new double[N][N];//f[][][steps]
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    for (int k = 0; k < 8; k++) {
                        int newX = x + dirs[k][0];
                        int newY = y + dirs[k][1];
                        if (inArea(newX, newY, N)) {
                            cur[newX][newY] += pre[x][y] / 8.0;
                        }
                    }
                }
            }
            pre = cur;
        }
        double ans = 0.0;
        for (double[] row : pre)
            for (double x : row)
                ans += x;
        return ans;
    }

    //记忆化搜索+递归
    private double[][][] dp;

    public double knightProbability3(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];
        return find(N, K, r, c);
    }

    public double find(int N, int K, int r, int c) {
        if (!inArea(r, c, N)) return 0;
        if (K == 0) return 1;

        if (dp[r][c][K] != 0) return dp[r][c][K];
        double p = 0;
        for (int i = 0; i < dirs.length; i++)
            p += 0.125 * find(N, K - 1, r + dirs[i][0], c + dirs[i][1]);
        dp[r][c][K] = p;//这步的记忆化很关键！
        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.knightProbability(6, 6, 0, 0));
//        System.out.println(solution.knightProbability2(6, 6, 0, 0));

        double time1 = System.currentTimeMillis();
        System.out.println("可移动次数为：" + 20);
        System.out.println("仍然在棋盘的概率：" + solution.knightProbability2(20, 70, 5, 3));//0.11734
        double time2 = System.currentTimeMillis();
        System.out.println("花费时间：" + ((time2 - time1) / 1000 + "s"));


    }
}