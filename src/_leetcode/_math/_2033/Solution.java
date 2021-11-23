package _leetcode._math._2033;

import java.util.Arrays;

/**
 * @Description: 2033. 获取单值网格的最小操作数
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 * 单值网格 是全部元素都相等的网格。
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。
 * @Date: 2021/11/10
 */

public class Solution {
    public int minOperations(int[][] grids, int x) {
        int n = grids.length;
        int m = grids[0].length;
        int[] arr = new int[m * n];
        int idx = 0;
        for (int[] grid : grids)
            for (int g : grid)
                arr[idx++] = g;
        Arrays.sort(arr);
        int mid = arr[(n * m) / 2];
        int sum = 0;
        for (int a : arr) {
            int l = Math.abs(mid - a);
            if (l % x != 0) return -1;
            sum += l / x;
        }
        return sum;
    }
}
