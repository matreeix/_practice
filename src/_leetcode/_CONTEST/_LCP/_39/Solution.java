package _leetcode._CONTEST._LCP._39;

/**
 * @Description: LCP 39. 无人机方阵
 * 在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。 无人机方阵通过两种操作进行颜色图案变换：
 * 调整无人机的位置布局
 * 切换无人机展示的灯光颜色
 * 给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，由于无人机切换灯光颜色的耗能很大，请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。
 * <p>
 * 注意： 调整无人机的位置布局时无人机的位置可以随意变动。
 * 提示：
 * n == source.length == target.length
 * m == source[i].length == target[i].length
 * 1 <= n, m <=100
 * 1 <= source[i][j], target[i][j] <=10^4
 * @Date: 2021/9/11
 */

public class Solution {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int[] cnt = new int[10001];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                cnt[source[i][j]]++;
                cnt[target[i][j]]--;
            }
        }
        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                res += Math.abs(cnt[i]);
            }
        }
        return res / 2;
    }
}
