package _leetcode._sort._56;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: Merge Intervals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * @Author: matreeix
 * @Date: 2020/7/13
 */

public class Solution {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);//左升序右降序
        int left = intervals[0][0], right = intervals[0][1];
        List<int[]> list = new LinkedList<>();
        for (int[] arr : intervals) {
            if (arr[1] > right && arr[0] <= right) {//拓宽右边界
                right = arr[1];
            } else if (arr[0] > right) {//无法拓宽，更新左右边界
                list.add(new int[]{left, right});
                left = arr[0];
                right = arr[1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {10, 13}, {17, 18}};

        System.out.println(Arrays.deepToString(merge(ints)));

    }
}
