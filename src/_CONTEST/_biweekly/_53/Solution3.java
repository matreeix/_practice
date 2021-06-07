package _CONTEST._biweekly._53;

import java.util.TreeSet;

/**
 * @Description: 5757. 矩阵中最大的三个菱形和
 * 给你一个 m x n 的整数矩阵 grid 。
 * 菱形和 指的是 grid 中一个正菱形 边界 上的元素之和。本题中的菱形必须为正方形旋转45度，且四个角都在一个格子当中。下图是四个可行的菱形，每个菱形和应该包含的格子都用了相应颜色标注在图中。
 * 注意，菱形可以是一个面积为 0 的区域，如上图中右下角的紫色菱形所示。
 * 请你按照 降序 返回 grid 中三个最大的 互不相同的菱形和 。如果不同的和少于三个，则将它们全部返回。
 * @Created by: matreeix
 * @Date: 2021/5/29
 */
public class Solution3 {
    public int[] getBiggestThree(int[][] g) {
        int m = g.length, n = g[0].length;
        int maxLength = (Math.min(m, n) + 1) / 2;//棱形的最长边长
        TreeSet<Integer> ans = new TreeSet<Integer>((x, y) -> y - x);//由大到小排序

        for (int len = 0; len < maxLength; len++)
            for (int i = 0; i < m - 2 * len; i++)
                for (int j = len; j < n - len; j++) {
                    int cur = g[i][j];//左顶点
                    for (int k = 1; k < 2 * len; k++) {
                        if (k <= len) {
                            cur += g[i + k][j - k] //左上边
                                    + g[i + k][j + k];//左下边
                        } else {
                            cur += g[i + k][j - (2 * len - k)] //右上边
                                    + g[i + k][j + (2 * len - k)];//右下边
                        }
                    }

                    cur += len == 0 ? 0 : g[i + 2 * len][j];//右顶点
                    ans.add(cur);
                    if (ans.size() > 3)//只存最大的三个值
                        ans.pollLast();
                }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
