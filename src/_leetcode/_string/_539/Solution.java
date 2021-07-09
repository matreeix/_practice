package _leetcode._string._539;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * @Date: 2021/7/9
 */

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] times = new int[n];
        int idx = 0;
        for(String time : timePoints){
            int tmp = Integer.parseInt(time.substring(0,2)) * 60 +  Integer.parseInt(time.substring(3));
            times[idx++] = tmp;
        }
        Arrays.sort(times);
        int res = 100000;
        for(int i = 1 ; i < n; i++){
            res = Math.min(res,times[i]-times[i-1]);
        }
        return  Math.min(res,1440 + times[0] - times[n-1]);
    }
}
