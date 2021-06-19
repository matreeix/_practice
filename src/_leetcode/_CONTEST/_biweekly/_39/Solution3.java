package _leetcode._CONTEST._biweekly._39;

import java.util.*;

/**
 * @Description: 5552. 到家的最少跳跃次数
 * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
 * <p>
 * 跳蚤跳跃的规则如下：
 * <p>
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何 forbidden 数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 * <p>
 * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
 * 提示：
 * <p>
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * forbidden 中所有位置互不相同。
 * 位置 x 不在 forbidden 中。
 * @Author: matreeix
 * @Date: 2020/11/14
 */

public class Solution3 {
    private int[] dp = new int[4001];
    private int front, back, pos;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i : forbidden) {
            dp[i] = -1;
        }
        front = a;
        back = b;
        pos = x;
        jump(0, 0, false);
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }

    public void jump(int cur, int step, boolean tag) {
        if (cur < 0 || cur > 4000 || step >= dp[cur]) return;
        dp[cur] = step;
        if (tag) {
            jump(cur - back, 1 + step, false);
        }
        jump(cur + front, 1 + step, true);
    }
}
