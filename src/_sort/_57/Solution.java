package _sort._57;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: Insert Interval
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * @Author: Pythagodzilla
 * @Date: 2020/7/13
 */

public class Solution {
    //直接法
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};
        if (newInterval == null || newInterval.length == 0)
            return intervals;

        List<int[]> list = new LinkedList<>();
        int left = newInterval[0], right = newInterval[1];//新区域的左右边界
        int mark = 0;//标记需要插入的位置
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {//新区间左侧
                list.add(interval);
                mark++;
            } else if (interval[0] <= newInterval[0] && interval[1] >= newInterval[1]) {//新区间被覆盖
                return intervals;
            } else if (interval[0] > newInterval[1]) {//新区间右侧
                list.add(interval);
            } else if (interval[0] < newInterval[0]) {//更新左边界
                left = interval[0];
            } else if (interval[1] > newInterval[1]) {//更新右边界
                right = interval[1];
            }
        }
        list.add(mark, new int[]{left, right});//插入新区间
        return list.toArray(new int[list.size()][]);
    }

    //二分搜索
    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};
        if (newInterval == null || newInterval.length == 0)
            return intervals;

        int n = intervals.length;
        if (intervals[0][0] > newInterval[1] || intervals[n - 1][1] < newInterval[0]) {//新区间超过范围
            int[][] a = new int[n + 1][2];
            for (int i = 0; i < n; i++) {
                if (intervals[0][0] > newInterval[1]) {
                    a[0] = newInterval;
                    a[i + 1] = intervals[i];
                } else {
                    a[i] = intervals[i];
                    a[n] = newInterval;
                }
            }
            return a;
        }
        int left, right;
        left = binarySearch(intervals, 1, newInterval[0], 0, n - 1);//和新区间相交的第一个子区间索引
        right = binarySearch(intervals, 0, newInterval[1], 0, n - 1);//和新区间相交的最后一个子区间索引

        int len = left + 1 + (n - 1 - right);
        int[][] a = new int[len][2];
        System.out.println(left);
        System.out.println(right);
        int min = Math.min(newInterval[0], intervals[left][0]);
        int max = Math.max(newInterval[1], intervals[right][1]);
        for (int i = 0; i < len; i++) {
            if (i < left)
                a[i] = intervals[i];
            else if (i == left)
                a[i] = new int[]{min, max};
            else
                a[i] = intervals[right + i - left];
        }
        return a;
    }

    private static int binarySearch(int[][] intervals, int mark, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (intervals[mid][mark] > target) {
                r = mid - 1;
            } else if (intervals[mid][mark] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return mark == 0 ? r : l;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {15, 17};

//        int[][] intervals = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};
        System.out.println(Arrays.deepToString(insert2(intervals, newInterval)));

    }
}
