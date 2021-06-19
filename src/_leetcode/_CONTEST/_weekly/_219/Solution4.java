package _leetcode._CONTEST._weekly._219;

import java.util.Arrays;

/**
 * @Description: 5245. 堆叠长方体的最大高度
 * 给你 n 个长方体 cuboids ，其中第 i 个长方体的长宽高表示为 cuboids[i] = [widthi, lengthi, heighti]（下标从 0 开始）。请你从 cuboids 选出一个 子集 ，并将它们堆叠起来。
 * 如果 widthi <= widthj 且 lengthi <= lengthj 且 heighti <= heightj ，你就可以将长方体 i 堆叠在长方体 j 上。你可以通过旋转把长方体的长宽高重新排列，以将它放在另一个长方体上。
 * 返回 堆叠长方体 cuboids 可以得到的 最大高度 。
 * @Author: matreeix
 * @Date: 2020/12/13
 */

public class Solution4 {
    public int maxHeight(int[][] cuboids) {
        for (int[] a : cuboids)
            Arrays.sort(a);
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];
            if (a[1] != b[1])
                return b[1] - a[1];
            return b[2] - a[2];
        });
        int n = cuboids.length, res = 0, dp[] = new int[n];
        for (int j = 0; j < n; ++j) {
            dp[j] = cuboids[j][2];
            for (int i = 0; i < j; ++i) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[j] = Math.max(dp[j], dp[i] + cuboids[j][2]);
                }
            }
            res = Math.max(res, dp[j]);
        }
        return res;
    }
}