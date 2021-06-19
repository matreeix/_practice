package _leetcode._DP._741;

import java.util.Arrays;

/**
 * @Description: 摘樱桃
 * @Linked: https://leetcode-cn.com/problems/cherry-pickup/solution/dong-tai-gui-hua-xiang-xi-jie-xi-tu-jie-by-newhar/
 * @Author: matreeix
 * @Date: 2020/5/9
 */
public class Solution {

    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N + 1][N + 1];
        for (int[] row : dp) {
            //使用了N+1的大小，因此边界值也设置为MIN_VALUE
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        //动态规划涉及方向，此题倒序来找
        dp[N - 1][N - 1] = grid[N - 1][N - 1];

        //sum表示一共要走的步数，也就是k，通过一个循环递增，来降低一个维度，从而不需要使用三维数组k那一维,
        for (int sum = 2 * N - 3; sum >= 0; sum--) {//当前走第sum步，一共要走2*N-2步,下标的话就是2N-3，注意是倒序的
            for (int i1 = Math.max(0, sum - N + 1); i1 <= Math.min(N - 1, sum); i1++) {
                for (int i2 = i1; i2 <= Math.min(N - 1, sum); i2++) {
                    //i1、j2的关联：一共要走sum步，sum<2*n，因此起点为Math.max(0,sum-N+1),
                    //限定了i1的范围，因此 j1 = sum -i1 = sum - (sum-n+1) = n-1,也就是当i1取最大，j1的下标也只能为n-1
                    //i2的优化：从i1开始计算，表明第二个人一定走在i1的下面
                    int j1 = sum - i1;
                    int j2 = sum - i2;
                    if (grid[i1][j1] == -1 || grid[i2][j2] == -1) {
                        dp[i1][i2] = Integer.MIN_VALUE;//遇到荆棘
                    } else {
                        if (i1 != i2 || j1 != j2) {
                            //不重合在同一个点，则获取的最大值=A的格子+B的格子+AB往哪个方向走，也就是上一个状态是怎么来得，
                            dp[i1][i2] = grid[i1][j1] + grid[i2][j2] + Math.max(Math.max(dp[i1][i2 + 1], dp[i1 + 1][i2]),
                                    Math.max(dp[i1][i2], dp[i1 + 1][i2 + 1]));
                        } else {
                            //重合在一个点，grid[i1][j1] == grid[i2][j2]，取一个即可，后面是4个方向
                            dp[i1][i2] = grid[i1][j1] + Math.max(Math.max(dp[i1][i2 + 1], dp[i1 + 1][i2]),
                                    Math.max(dp[i1][i2], dp[i1 + 1][i2 + 1]));
                        }
                    }
                }
            }
        }

        return Math.max(0, dp[0][0]);
    }
}
