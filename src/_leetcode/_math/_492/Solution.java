package _leetcode._math._492;

import java.util.Arrays;

/**
 * @Description: 492. 构造矩形
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 * <p>
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 * @Author: matreeix
 * @Date: 2020/9/25
 */

public class Solution {
    public static int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt == area)
            return new int[]{sqrt, sqrt};
        int W = 0, L = 0;

        while (sqrt > 0) {
            if (area % sqrt == 0) {
                W = sqrt;
                L = area / sqrt;
                break;
            } else {
                sqrt--;
            }
        }

        return new int[]{L, W};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle(12)));
    }
}
