package _CONTEST._biweekly._37;

import java.util.Arrays;

/**
 * @Description: 5528. 网络信号最好的坐标
 * 给你一个数组 towers 和一个整数 radius ，数组中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信号强度参数为 qi 。所有坐标都是在  X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。
 * 整数 radius 表示一个塔 能到达 的 最远距离 。如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius 以外的距离该塔是 不能到达的 。
 * 如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。一个坐标的 网络信号 是所有 能到达 该坐标的塔的信号强度之和。
 * 请你返回 网络信号 最大的整数坐标点。如果有多个坐标网络信号一样大，请你返回字典序最小的一个坐标。
 * <p>
 * 注意：
 * 坐标 (x1, y1) 字典序比另一个坐标 (x2, y2) 小：要么 x1 < x2 ，要么 x1 == x2 且 y1 < y2 。
 * ⌊val⌋ 表示小于等于 val 的最大整数（向下取整函数）。
 * <p>
 * 提示：
 * 1 <= towers.length <= 50
 * towers[i].length == 3
 * 0 <= xi, yi, qi <= 50
 * 1 <= radius <= 50
 * @Author: matreeix
 * @Date: 2020/10/18
 */

public class Solution2 {
    public static int[] bestCoordinate(int[][] towers, int radius) {
        int Xmin = Integer.MAX_VALUE;
        int Xmax = Integer.MIN_VALUE;
        int Ymin = Integer.MAX_VALUE;
        int Ymax = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            Xmin = Math.min(tower[0], Xmin);
            Xmax = Math.max(tower[0], Xmax);
            Ymin = Math.min(tower[1], Ymin);
            Ymax = Math.max(tower[1], Ymax);
        }
        int[] res = new int[2];
        int sum = 0;//信号强度和
        for (int i = Xmin; i <= Xmax; i++) {
            for (int j = Ymin; j <= Ymax; j++) {
                int tmp = 0;
                for (int[] tower : towers) {
                    int d = (i - tower[0]) * (i - tower[0]) + (j - tower[1]) * (j - tower[1]);
                    if (d <= radius * radius) {//信号可以到达
                        tmp += (int) (tower[2] / (1 + Math.sqrt(d)));
                    }
                }
                if (tmp > sum) {//信号更强就更新坐标
                    res[0] = i;
                    res[1] = j;
                    sum = tmp;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int[][] towers2 = {{23,11,21}};
        int radius = 2;
        System.out.println(Arrays.toString(bestCoordinate(towers, radius)));
        System.out.println(Arrays.toString(bestCoordinate(towers2, 9)));
    }
}
