package _leetcode._Cracking_the_Coding_Interview._16._13;

/**
 * @Description: 面试题 16.13. 平分正方形
 * 给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。
 * <p>
 * 每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，以及正方形的边长square[2]。
 * 所求直线穿过两个正方形会形成4个交点，请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，这2个点所连成的线段一定会穿过另外2个交点）。
 * 2个端点坐标[X1,Y1]和[X2,Y2]的返回格式为{X1,Y1,X2,Y2}，要求若X1 != X2，需保证X1 < X2，否则需保证Y1 <= Y2。
 * <p>
 * 若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与Y轴平行的直线视为斜率无穷大）。
 * @Author: matreeix
 * @Date: 2020/11/5
 */

public class Solution {
    public double[] cutSquares(int[] square1, int[] square2) {
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0;//俩正方形的中心坐标
        x1 = square1[0] + square1[2] / 2.0;
        y1 = square1[1] + square1[2] / 2.0;
        x2 = square2[0] + square2[2] / 2.0;
        y2 = square2[1] + square2[2] / 2.0;

        double Xmin = 0, Ymin = 0, Xmax = 0, Ymax = 0;
        if (x1 == x2) {//划分线平行y轴
            Xmin = Xmax = x1;
            Ymin = Math.min(square1[1], square2[1]);
            Ymax = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
        } else {
            double k = (y2 - y1) / (x2 - x1);//斜率
            if (Math.abs(k) <= 1) {
                Xmin = Math.min(square1[0], square2[0]);
                Xmax = Math.max(square1[0] + square1[2], square2[0] + square2[2]);
                Xmin = Math.min(Xmin, Xmax);
                Xmax = Math.max(Xmin, Xmax);
                Ymin = k * (Xmin - x1) + y1;
                Ymax = k * (Xmax - x1) + y1;
            } else {
                Ymin = Math.min(square1[1], square2[1]);
                Ymax = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
                Xmin = (Ymin - y1) / k + x1;
                Xmax = (Ymax - y1) / k + x1;
                if (Xmin > Xmax) {//不合规的输出要交换位置
                    double tmp = Xmin;
                    Xmin = Xmax;
                    Xmax = tmp;

                    tmp = Ymin;
                    Ymin = Ymax;
                    Ymax = tmp;
                }

            }
        }
        return new double[]{Xmin, Ymin, Xmax, Ymax};
    }
}
