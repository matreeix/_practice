package _CONTEST._biweekly._38;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 1637. 两点之间不包含任何点的最宽垂直面积
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直面积 的宽度。
 * <p>
 * 垂直面积 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积 为宽度最大的一个垂直面积。
 * <p>
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * @Author: matreeix
 * @Date: 2020/11/3
 */

public class Solution2 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        for (int i = 1; i < points.length; i++)
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        return res;
    }

    public int maxWidthOfVerticalArea2(int[][] points) {
        int[] x = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int res = 1;
        for (int i = 0; i < points.length - 1; i++) {
            res = Math.max(res,x[i + 1] - x[i]);
        }
        return res;
    }
}
