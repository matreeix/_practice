package _greedy._435;

import java.util.Arrays;

/**
 * @Description: 无重叠区间
 * @Author: 67ng
 * @Date: 5/12/2020
 */
public class Solution {

    //貪心算法
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][intervals[0].length-1], prev = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][intervals[prev].length-1] > intervals[i][0]) {
                if (intervals[prev][intervals[prev].length-1] > intervals[i][intervals[i].length-1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }


}
