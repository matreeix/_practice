package _leetcode._math._836;

/**
 * @Description: 836. 矩形重叠
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 * 提示：
 * rect1.length == 4
 * rect2.length == 4
 * -109 <= rec1[i], rec2[i] <= 109
 * rec1[0] <= rec1[2] 且 rec1[1] <= rec1[3]
 * rec2[0] <= rec2[2] 且 rec2[1] <= rec2[3]
 * @Created by: matreeix
 * @Date: 2021/5/4
 */
public class Solution {
    //比较投影
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&//x轴投影
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));//y轴投影
    }
}
