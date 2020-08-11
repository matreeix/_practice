package _math._478;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Author: caffebaby
 * @Date: 2020/5/18
 */
public class Solution {
    private double radius;
    private double x_center;
    private double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

//    public double[] randPoint() {
//        double Xmin = x_center - radius;
//        double Xmax = x_center + radius;
//        double X = Math.random() * (Xmax - Xmin) + Xmin;
//        double Ymin = y_center - Math.sqrt(radius * radius - X * X);
//        double Ymax = y_center + Math.sqrt(radius * radius - X * X);
//        double Y = Math.random() * (Ymax - Ymin) + Ymin;
//        return new double[]{X, Y};
//    }

    //x_coord=X⋅cosθ
    //y_coord=X⋅sinθ
    public double[] randPoint() {
        double d = radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + x_center, d * Math.sin(theta) + y_center};
    }

    public static void main(String[] args) {
        double radius = 1.0;
        double x_center = 0;
        double y_center = 0;
        Solution obj = new Solution(radius, x_center, y_center);
        double[] param1 = obj.randPoint();
        System.out.println(Arrays.toString(param1));

    }
}

