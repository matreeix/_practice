package _leetcode._array._495;

/**
 * @Description: 提莫攻击，计算中毒持续时间
 * @Author: matreeix
 * @Date: 2020/2/28
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        if (duration <= 0) return 0;
        if (timeSeries.length == 1) return duration;
        int more = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] > duration)
                more += timeSeries[i] - timeSeries[i - 1] - duration;
        }
        return timeSeries[timeSeries.length - 1] - timeSeries[0] + duration - more;
    }
}
