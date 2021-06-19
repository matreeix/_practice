package _leetcode._hashtable._149;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 149. 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * @Author: matreeix
 * @Date: 2020/11/7
 */

public class Solution {
    //哈希表，时间复杂度O(n ^ 2)
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y))
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    else
                        map.get(x).put(y, 1);
                } else {
                    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    //得到最大公约数,O(n ^ 3)
    private int generateGCD(int a, int b) {
        if (b == 0) return a;
        else return generateGCD(b, a % b);
    }

    //向量法,仅仅适用于无重复点
    public static int maxPoints2(int[][] points) {
        int cnt;//记录直线穿过点的数量
        int maxp = 0;//记录cnt的最大值
        int n = points.length;
        if (n < 3) return n;
        int repeat = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                cnt = 2;//先确定两个点
                if (n - 1 - j + 1 + 1 <= maxp)
                    break;
                long x1 = points[j][0] - points[i][0];
                long y1 = points[j][1] - points[i][1];
                for (int k = j + 1; k < n; k++) {//不断更新第三个点
                    long x2 = points[k][0] - points[i][0];
                    long y2 = points[k][1] - points[i][1];
                    if (x1 * y2 == x2 * y1)//判断两个向量，即三点是否共线
                        cnt++;
                }
                maxp = Math.max(maxp, cnt);
            }
        }
        return maxp;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {1, 1}, {1, 1}, {1, 1}};
        System.out.println(maxPoints2(points));
    }
}
