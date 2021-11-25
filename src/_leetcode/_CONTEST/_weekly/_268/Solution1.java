package _leetcode._CONTEST._weekly._268;

/**
 * @Description: 5930. 两栋颜色不同且距离最远的房子
 * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
 * @Date: 2021/11/21
 */

public class Solution1 {
    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int l = 0, r = n - 1;
        while (l < n - 1) {
            if (colors[l] != colors[n - 1]) break;
            l++;
        }
        while (r > 0) {
            if (colors[r] != colors[0]) break;
            r--;
        }
        return Math.max(n - 1 - l, r);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 6, 1, 1, 1};
        System.out.println(maxDistance(arr));
    }
}
