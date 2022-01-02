package _leetcode._CONTEST._weekly._274;

import java.util.Arrays;

/**
 * @Description: 5969. 摧毁小行星
 * 给你一个整数 mass ，它表示一颗行星的初始质量。再给你一个整数数组 asteroids ，其中 asteroids[i] 是第 i 颗小行星的质量。
 * 你可以按 任意顺序 重新安排小行星的顺序，然后让行星跟它们发生碰撞。如果行星碰撞时的质量 大于等于 小行星的质量，那么小行星被 摧毁 ，并且行星会 获得 这颗小行星的质量。否则，行星将被摧毁。
 * 如果所有小行星 都 能被摧毁，请返回 true ，否则返回 false 。
 * 提示：
 * 1 <= mass <= 10^5
 * 1 <= asteroids.length <= 10^5
 * 1 <= asteroids[i] <= 10^5
 * @Date: 2022/1/2
 */

public class Solution3 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long massTmp = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (massTmp < asteroids[i])
                return false;
            massTmp += asteroids[i];
        }
        return true;
    }

    //获得二进制有几位，从0开始
    public int getH(int x) {
        int cnt = 0;
        while (x != 1) {
            x >>= 1;
            cnt++;
        }
        return cnt;
    }

    public boolean asteroidsDestroyed2(int mass, int[] asteroids) {
        //根据数据范围，最多不超过17位
        long[] sum = new long[17];
        int[] min = new int[17];
        for (int i = 0; i < asteroids.length; i++) {
            int h = getH(asteroids[i]);
            if (asteroids[i] < min[h] || min[h] == 0) {
                min[h] = asteroids[i];
            }
            sum[h] += asteroids[i];// 记录[2^i,2^(i+1))间所有数的和，在该区间的所有小行星都可以被摧毁
        }
        long cur = mass;
        for (int i = 0; i < 17; i++) {
            if (cur >= min[i]) {
                cur += sum[i];
            } else {
                return false;
            }
        }
        return true;
    }

}
