package _CONTEST._weekly._197;

/**
 * @Description: Best Position for a Service Centre
 * <p>
 * A delivery company wants to build a new service centre in a new city. The company knows the positions of all the customers
 * in this city on a 2D-Map and wants to build the new centre in a position such that the sum of the euclidean distances to all customers is minimum.
 * Given an array positions where positions[i] = [xi, yi] is the position of the ith customer on the map, return the minimum sum of the euclidean distances to all customers.
 * In other words, you need to choose the position of the service centre [xcentre, ycentre] such that the following formula is minimized:
 * Answers within 10^-5 of the actual value will be accepted.
 * @Author: Pythagodzilla
 * @Date: 2020/7/12
 */

public class Solution4 {

    /**
     * 思路：梯度下降算法
     * 1.搜索精度较低的大区域
     * 2.一旦获得最接近的点，以更高的精度搜索该点附近区域(x10)
     */
    public static double getMinDistSum(int[][] positions) {
        double left = 100, bottom = 100, right = 0, top = 0;
        for (int[] p : positions) {//确定所有点的边界
            left = Math.min(left, p[0]);
            bottom = Math.min(bottom, p[1]);
            right = Math.max(right, p[0]);
            top = Math.max(top, p[1]);
        }
        double res = Double.MAX_VALUE, res_x = 0, res_y = 0;
        for (double delta = 10; delta >= 0.00001; delta /= 10) {//缩小率
            for (double x = left; x <= right; x += delta)//左右分块
                for (double y = bottom; y <= top; y += delta) {//上下分块
                    double d = 0;
                    for (int[] p : positions)
                        d += Math.sqrt((p[0] - x) * (p[0] - x) + (p[1] - y) * (p[1] - y));
                    if (res > d) {
                        res = d;
                        res_x = x;
                        res_y = y;
                    }
                }
            //生成新的区域范围
            left = res_x - delta;
            bottom = res_y - delta;
            right = res_x + delta;
            top = res_y + delta;
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[][] positions = {{0, 1}, {3, 2}, {4, 5}, {7, 6}, {8, 9}, {11, 1}, {2, 12}};
        System.out.println(getMinDistSum(positions));

    }
}