package _leetcode._CONTEST._biweekly._66;

/**
 * @Description: 5924. 网格图中机器人回家的最小代价
 * 给你一个 m x n 的网格图，其中 (0, 0) 是最左上角的格子，(m - 1, n - 1) 是最右下角的格子。给你一个整数数组
 * startPos ，startPos = [startrow, startcol] 表示 初始 有一个 机器人 在格子 (startrow, startcol) 处。
 * 同时给你一个整数数组 homePos ，homePos = [homerow, homecol] 表示机器人的 家 在格子 (homerow, homecol) 处。
 * 机器人需要回家。每一步它可以往四个方向移动：上，下，左，右，同时机器人不能移出边界。每一步移动都有一定代价。再给你两个下标从 0 开始的额整数数组：长度为 m 的数组 rowCosts  和长度为 n 的数组 colCosts 。
 * 如果机器人往 上 或者往 下 移动到第 r 行 的格子，那么代价为 rowCosts[r] 。
 * 如果机器人往 左 或者往 右 移动到第 c 列 的格子，那么代价为 colCosts[c] 。
 * 请你返回机器人回家需要的 最小总代价 。
 * 提示：
 * <p>
 * m == rowCosts.length
 * n == colCosts.length
 * 1 <= m, n <= 10^5
 * 0 <= rowCosts[r], colCosts[c] <= 10^4
 * startPos.length == 2
 * homePos.length == 2
 * 0 <= startrow, homerow < m
 * 0 <= startcol, homecol < n
 * @Date: 2021/11/28
 */

public class Solution3 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;
        if (startPos[0] < homePos[0])
            for (int i = startPos[0] + 1; i <= homePos[0]; i++)
                res += rowCosts[i];
        else
            for (int i = startPos[0] - 1; i >= homePos[0]; i--)
                res += rowCosts[i];
        if (startPos[1] < homePos[1])
            for (int i = startPos[1] + 1; i <= homePos[1]; i++)
                res += colCosts[i];
        else
            for (int i = startPos[1] - 1; i >= homePos[1]; i--)
                res += colCosts[i];
        return res;
    }

    public static void main(String[] args) {
        int[] start = {5, 5};
        int[] end = {5, 2};
        int[] rowCosts = {7, 1, 3, 3, 5, 3, 22, 10, 23};
        int[] colCosts = {5, 5, 6, 2, 0, 16};
    }

}
