package _leetcode._CONTEST._weekly._209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1610. 可见点的最大数目
 * 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
 * 最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示，
 * 这决定了你观测任意方向时可以多宽。设 d 为逆时针旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
 * 对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度 位于你的视野中 ，那么你就可以看到它。
 * <p>
 * 同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
 * <p>
 * 返回你能看到的点的最大数目。
 * @Author: matreeix
 * @Date: 2020/10/8
 */

public class Solution3 {
    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        double[] angles = new double[200000];
//        double[] angles = new double[20];
        Arrays.fill(angles, 10000.0);
        int x0 = location.get(0);
        int y0 = location.get(1);
        int idx = 0;

        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (x0 == x) {
                angles[idx++] = y > y0 ? 90.0 : (y < y0 ? 270.0 : 1000.0);
            } else if (x0 > x) {
                angles[idx++] = 180.0 + Math.toDegrees(Math.atan((double) (y - y0) / (x - x0)));
            } else {//x0<x
                angles[idx++] = y >= y0 ? Math.toDegrees(Math.atan((double) (y - y0) / (x - x0)))
                        : (360.0 + Math.toDegrees(Math.atan((double) (y - y0) / (x - x0))));
            }
        }
        for (int i = idx; i < 2 * idx; i++) {
            angles[i] = angles[i - idx] + 360.0;
        }
//
//        for (int i = 0; i < 10; i++)
//            System.out.println(angles[i]);

        Arrays.sort(angles);
//        for (int i = 0; i < 200; i++)
//            System.out.println(angles[i]);

        int res = 0, l = 0, r = 0;
        while (angles[r] < 360.0 + angle) {
            while (angles[r] - angles[l] <= angle && angles[r] < 360.0 + angle) {
                r++;
            }
            res = Math.max(res, r - l);
            l++;
        }

        while (angles[r] < 10000.0 && r < 199999) {//记录和原点重合的点
            if (angles[r++] == 1000.0)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> point1 = new ArrayList<>();
        List<Integer> point2 = new ArrayList<>();
        List<Integer> point3 = new ArrayList<>();
        List<Integer> point4 = new ArrayList<>();
        List<Integer> location = new ArrayList<>();
        point1.add(1);
        point1.add(1);
        point2.add(2);
        point2.add(2);
        point3.add(1);
        point3.add(2);
        point4.add(2);
        point4.add(1);
        location.add(1);
        location.add(1);
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        int angle = 0;

        System.out.println(visiblePoints(points, angle, location));//4


//        int[][] aa = {{198768142, 325231488}, {730653894, 526879029}, {482566443, 124650516}, {301750308, 786306795}, {428637509, 388444545}, {824139468, 560868920},
//                {46101719, 541790947}, {33117389, 306138652}, {379129552, 739264502}, {632078701, 382510936}, {648669937, 641406148}, {402494603, 290848535},
//                {681757446, 651339050}, {755146968, 328108553}, {856055968, 54585842}, {642810790, 781285498}, {624780623, 839525682}, {225552068, 597591380},
//                {941428680, 575243295}, {904246597, 409781914}, {133988308, 424694994}, {263860625, 642729245}, {725256971, 428462957}, {951188673, 24284291},
//                {65878467, 597579989}, {423910337, 760218568}, {375233659, 465709839}, {39079416, 44449206}, {76488044, 376497238}, {768046853, 401132958},
//                {862857872, 713625310}, {834212457, 613684155}, {145940546, 414657761}, {438671565, 895069996}, {486059332, 78047139}, {539611528, 236860222},
//                {328891159, 833572609}, {561041358, 896191043}, {469734995, 511499580}, {868786087, 593647615}, {502014973, 630219398}, {834825976, 939531210},
//                {232809706, 831430339}, {446916520, 518080962}, {516594877, 208057152}, {851130172, 768268153}, {665228968, 134767900}, {347594646, 46036486},
//                {675842115, 24895986}, {877430373, 353382710}, {167579980, 47992154}, {125351210, 769215749}, {438404131, 569154245}, {604952972, 128325995},
//                {304627075, 646626043}, {651998767, 527382342}, {121415369, 22955171}, {46278664, 726969424}, {650197837, 730272955}, {326340006, 424213045},
//                {242071539, 679004233}, {208227275, 449583956}, {688763276, 330569373}, {657221239, 659946024}, {760680906, 398786962}, {695186876, 163719246},
//                {416909447, 908414565}, {59247263, 674732497}, {396812330, 607544608}, {752069054, 728117920}};
//        List<List<Integer>> points = new ArrayList<>();
//
//        for (int[] a : aa) {
//            List<Integer> point = new ArrayList<>();
//            point.add(a[0]);
//            point.add(a[1]);
//            points.add(point);
//        }
//        List<Integer> location = new ArrayList<>();
//        location.add(136181398);
//        location.add(475556834);
//        System.out.println(visiblePoints(points, 86, location));//45

    }

}
