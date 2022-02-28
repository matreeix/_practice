package _leetcode._CONTEST._weekly._282;

import java.util.Arrays;

/**
 * @Description: 6010. 完成旅途的最少时间
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，
 * 也就是说可以同时有多辆公交车在运行且互不影响。
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 * 提示：
 * 1 <= time.length <= 10^5
 * 1 <= time[i], totalTrips <= 10^7
 * @Date: 2022/2/27
 */

public class Solution3 {
    public static long minimumTime(int[] time, int totalTrips) {
        long l = 0, r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (cnt(mid, time) < totalTrips) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return l;
    }

    private static long cnt(long cos, int[] time) {
        long sum = 0;
        for (int t : time) {
            sum += cos / t;
            if (sum < 0)
                return Long.MAX_VALUE;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] time = {39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25};
        int t = 4187;
        System.out.println(minimumTime(time, t));//858
    }
}
