package _DP._62;

/**
 * @Description: 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @Author: matreeix
 * @Date: 2020/6/30
 */

public class Solution {
    //dp
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

    //数学法，总排列=（m + n）！/（m！* n！）
    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if (m < n) {// Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {//Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(2, 3));//3
        System.out.println(s.uniquePaths(7, 3));//28
    }
}
