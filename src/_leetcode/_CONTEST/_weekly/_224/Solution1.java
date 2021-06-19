package _leetcode._CONTEST._weekly._224;

/**
 * @Description: 5653. 可以形成最大正方形的矩形数目
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 * 返回可以切出边长为 maxLen 的正方形的矩形 数目 。
 * @Date: 2021/1/17
 */

public class Solution1 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, cnt = 0;
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if (min > maxLen) {
                maxLen = min;
                cnt = 1;
            } else if (min == maxLen) {
                cnt++;
            }
        }
        return cnt;
    }
}
