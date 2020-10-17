package _Cracking_the_Coding_Interview._16._03;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2020/10/17
 */

public class Solution2 {
    //叉积法
    double[] ans = new double[0];

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int ax = start1[0], ay = start1[1], bx = end1[0], by = end1[1];
        int cx = start2[0], cy = start2[1], dx = end2[0], dy = end2[1];
        int acx = cx - ax, acy = cy - ay, abx = bx - ax, aby = by - ay, adx = dx - ax, ady = dy - ay;
        int cax = ax - cx, cay = ay - cy, cbx = bx - cx, cby = by - cy, cdx = dx - cx, cdy = dy - cy;
        // 共线处理和 T 形处理
        if (cross(cax, cay, cbx, cby) == 0 || cross(adx, ady, abx, aby) == 0) {
            boolean aInCd = bothSide(ax, ay, cx, cy, dx, dy), bInCd = bothSide(bx, by, cx, cy, dx, dy);
            boolean cInAb = bothSide(cx, cy, ax, ay, bx, by), dInAb = bothSide(dx, dy, ax, ay, bx, by);
            if (aInCd) {
                update(ax, ay);
            }
            if (bInCd) {
                update(bx, by);
            }
            if (cInAb) {
                update(cx, cy);
            }
            if (dInAb) {
                update(dx, dy);
            }
            return ans;
        }

        if (!intersect(acx, acy, abx, aby, adx, ady, cax, cay, cbx, cby, cdx, cdy)) {
            return new double[0];
        }
        // 定比分点
        double ck = getArea(ax, ay, bx, by, cx, cy), dk = getArea(ax, ay, bx, by, dx, dy);
        double k = ck / dk;
        double rx = (cx + k * dx) / (1 + k), ry = (cy + k * dy) / (1 + k);
        return new double[]{rx, ry};
    }

    // 判断线段 (ux, uy) -- (vx, vy) 是否包含 (mx, my)
    public boolean bothSide(int mx, int my, int ux, int uy, int vx, int vy) {
        double um = Math.sqrt((ux - mx) * (ux - mx) + (uy - my) * (uy - my));
        double vm = Math.sqrt((vx - mx) * (vx - mx) + (vy - my) * (vy - my));
        double uv = Math.sqrt((vx - ux) * (vx - ux) + (vy - uy) * (vy - uy));
        return (ux - mx) * (vx - mx) <= 0 && (uy - my) * (vy - my) <= 0;
    }

    // 叉积运算
    public int cross(int ux, int uy, int vx, int vy) {
        return ux * vy - vx * uy;
    }

    public void update(double x, double y) {
        // 以 x 为第一关键字，y 为第二关键字比较两个点的大小
        // 将一个交点与当前 ans 中的结果进行比较
        // 若更优则替换
        if (ans.length == 0 || x < ans[0] || (x == ans[0] && y < ans[1])) {
            ans = new double[]{x, y};
        }
    }

    // 判断两条线段是否有公共点
    public boolean intersect(int acx, int acy, int abx, int aby, int adx, int ady, int cax, int cay, int cbx, int cby, int cdx, int cdy) {
        return cross(acx, acy, abx, aby) * cross(adx, ady, abx, aby) <= 0 && cross(cax, cay, cdx, cdy) * cross(cbx, cby, cdx, cdy) <= 0;
    }

    // 计算三角形 PQM 的面积
    public double getArea(int px, int py, int qx, int qy, int mx, int my) {
        int mpx = px - mx, mpy = py - my, mqx = qx - mx, mqy = qy - my;
        return Math.abs(0.5 * cross(mpx, mpy, mqx, mqy));
    }
}
