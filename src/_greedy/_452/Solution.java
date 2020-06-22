package _greedy._452;

import java.util.Arrays;

/**
 * @Description: 用最少数量的箭引爆气球
 * @Author: Pythagodzilla
 * @Date: 2020/6/21
 */

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);//先按左边界排序
        int count = 1;
        int x_end = points[0][1];
        for (int[] point : points) {
            if (point[0] > x_end) {
                count++;
                x_end = point[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] points0 = {{1, 6}, {2, 8}, {7, 12}, {10, 16}};//2
        int[][] points00 = {{1, 3}, {2, 5}, {4, 6}, {7, 8}, {9, 11}, {10, 11}, {10, 12}};//4
        int[][] points1 = {{9, 11}, {10, 11}, {10, 12}};//多个相交 1
        int[][] points2 = {{1, 3}, {2, 5}, {4, 6}};//两辆相交 2
        int[][] points3 = {{1, 3}, {3, 5}};//边界相交 1
        int[][] points4 = {{1, 2}, {3, 4}, {5, 6}};//不相交 3
        int[][] points5 = {{1, 2}, {1, 4}, {3, 6}};//覆盖相交 2
        int[][] points6 = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        Solution s = new Solution();
        System.out.println(s.findMinArrowShots(points1));
        System.out.println(s.findMinArrowShots(points2));
        System.out.println(s.findMinArrowShots(points3));
        System.out.println(s.findMinArrowShots(points4));
        System.out.println(s.findMinArrowShots(points5));
        System.out.println(s.findMinArrowShots(points6));
//        System.out.println(s.findMinArrowShots(points0));
//        System.out.println(s.findMinArrowShots(points00));

    }
}
