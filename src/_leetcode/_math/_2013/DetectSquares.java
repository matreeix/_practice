package _leetcode._math._2013;

import java.util.*;

/**
 * @Description: 2013. 检测正方形
 * 给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
 * 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
 * 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
 * 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
 * <p>
 * 实现 DetectSquares 类：
 * <p>
 * DetectSquares() 使用空数据结构初始化对象
 * void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
 * int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。
 * @Date: 2021/9/29
 */

public class DetectSquares {
    int[][] cntPoints = new int[1001][1001];
    List<int[]> points = new ArrayList<>();

    public void add(int[] p) {
        cntPoints[p[0]][p[1]] += 1;
        points.add(p);
    }

    public int count(int[] p1) {
        int x0 = p1[0], y0 = p1[1], ans = 0;
        for (int[] point : points) {
            int tmpX = point[0], tmpY = point[1];
            if (Math.abs(x0 - tmpX) == 0
                    || Math.abs(x0 - tmpX) != Math.abs(y0 - tmpY))// 遍历对角点，妙啊！
                continue; // Skip empty square or invalid square point!
            ans += cntPoints[x0][tmpY] * cntPoints[tmpX][y0];
        }
        return ans;
    }

    public static void main(String[] args) {
        DetectSquares d = new DetectSquares();
        d.add(new int[]{3, 10});
        d.add(new int[]{11, 2});
        d.add(new int[]{3, 2});
        int cnt1 = d.count(new int[]{11, 10});
        int cnt2 = d.count(new int[]{14, 8});
        d.add(new int[]{11, 2});
        int cnt3 = d.count(new int[]{11, 10});
        System.out.println(cnt1);//1
        System.out.println(cnt2);//0
        System.out.println(cnt3);//2
    }
}
