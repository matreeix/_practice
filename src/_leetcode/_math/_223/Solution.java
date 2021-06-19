package _leetcode._math._223;

/**
 * @Description: 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * 1.第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 2.第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 * @Created by: matreeix
 * @Date: 2021/5/18
 */
public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int w = 0, h = 0;

        int y1 = Math.min(ay2, by2);
        int y2 = Math.max(ay1, by1);
        h = y1 > y2 ? y1 - y2 : 0;

        int x1 = Math.min(ax2, bx2);
        int x2 = Math.max(ax1, bx1);
        w = x1 > x2 ? x1 - x2 : 0;

        int S = 0, S1 = 0, S2 = 0;
        S1 = (ay2 - ay1) * (ax2 - ax1);
        S2 = (by2 - by1) * (bx2 - bx1);

        S = S1 + S2 - w * h;
        return S;
    }

}
