package _leetcode._CONTEST._weekly._282;

import java.util.Arrays;

/**
 * @Description: 6011. 完成比赛的最少时间
 * 给你一个下标从 0 开始的二维整数数组 tires ，其中 tires[i] = [fi, ri] 表示第 i 种轮胎如果连续使用，第 x 圈需要耗时 fi * ri(x-1) 秒。
 * 比方说，如果 fi = 3 且 ri = 2 ，且一直使用这种类型的同一条轮胎，那么该轮胎完成第 1 圈赛道耗时 3 秒，完成第 2 圈耗时 3 * 2 = 6 秒，完成第 3 圈耗时 3 * 22 = 12 秒，依次类推。
 * 同时给你一个整数 changeTime 和一个整数 numLaps 。
 * 比赛总共包含 numLaps 圈，你可以选择 任意 一种轮胎开始比赛。每一种轮胎都有 无数条 。每一圈后，你可以选择耗费 changeTime 秒 换成 任意一种轮胎（也可以换成当前种类的新轮胎）。
 * 请你返回完成比赛需要耗费的 最少 时间。
 * 提示：
 *
 * 1 <= tires.length <= 10^5
 * tires[i].length == 2
 * 1 <= fi, changeTime <= 10^5
 * 2 <= ri <= 10^5
 * 1 <= numLaps <= 1000
 *
 * @Date: 2022/2/27
 */

public class Solution4 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] minSec = new int[18];//同一个轮胎跑i圈的最小花销
        Arrays.fill(minSec, Integer.MAX_VALUE / 2); // 除二是防止下面计算状态转移时溢出
        for (int[] tire : tires) {
            long time = tire[0];
            for (int x = 1, sum = 0; time <= changeTime + tire[0]; ++x) {
                sum += time;
                minSec[x] = Math.min(minSec[x], sum);
                time *= tire[1];
            }
        }

        int[] f = new int[numLaps + 1];// f[i] 表示跑 i 圈的最小耗时
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = -changeTime;
        for (int i = 1; i <= numLaps; ++i) {
            for (int j = 1; j <= Math.min(17, i); ++j)
                f[i] = Math.min(f[i], f[i - j] + minSec[j]);
            f[i] += changeTime;
        }
        return f[numLaps];
    }

}
