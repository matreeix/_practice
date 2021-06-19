package _leetcode._search._1482;

import java.util.Arrays;

/**
 * @Description: 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * @Author: matreeix
 * @Date: 2020/8/17
 */

public class Solution {
    public static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int[] old = Arrays.copyOf(bloomDay, bloomDay.length);
        Arrays.sort(bloomDay);
        int l = 0;
        int r = bloomDay[bloomDay.length - 1];
        int day = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(old, m, k, mid)) {
                day = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return day;
    }

    /**
     * 判断是否可以制作m束花，所需要的最小天数min
     */
    private static boolean check(int[] old, int m, int k, int min) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < old.length; i++) {
            if (old[i] <= min) {
                count++;
                if (count == k) {
                    res++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return res >= m;
    }

    public static void main(String[] args) {
//        int bloomDay[] = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, m = 4, k = 2;
//        int bloomDay[] = {1,10,3,10,2}, m = 3, k =1;
        int bloomDay[] = {1000000000,1000000000}, m = 1, k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

}
