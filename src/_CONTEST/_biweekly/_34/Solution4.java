package _CONTEST._biweekly._34;

import java.util.Arrays;

/**
 * @Description: 5494. 统计所有可行路径
 * 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * 每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
 * 请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
 * 请你返回从 start 到 finish 所有可能路径的数目。
 * <p>
 * 由于答案可能很大， 请将它对 10^9 + 7 取余后返回。
 * @Author: matreeix
 * @Date: 2020/9/5
 */

public class Solution4 {
    //DFS+DP
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        long[][] dp = new long[n][fuel + 1];
        for (int i = 0; i < n; ++i)
            Arrays.fill(dp[i], -1);

        return (int) solve(locations, start, finish, dp, fuel);
    }

    private long solve(int[] locations, int curCity, int e, long[][] dp, int fuel) {
        if (fuel < 0) return 0;//燃料耗尽返回0
        if (dp[curCity][fuel] != -1) return dp[curCity][fuel];//重叠子结构
        // 到达终点后路径加1，但还是要继续递归
        long ans = (curCity == e) ? 1 : 0;
        for (int nextCity = 0; nextCity < locations.length; ++nextCity) {
            if (nextCity != curCity) {//继续访问除当前城市外的其他城市
                ans = (ans + solve(locations, nextCity, e, dp, fuel - Math.abs(locations[curCity] - locations[nextCity]))) % 1000000007;
            }
        }
        return dp[curCity][fuel] = ans;
    }
}
