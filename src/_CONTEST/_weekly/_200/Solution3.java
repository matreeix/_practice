package _CONTEST._weekly._200;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 5477. 排布二进制网格的最少交换次数
 * 给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
 * 一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
 * 请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
 * <p>
 * 主对角线指的是从 (1, 1) 到 (n, n) 的这些格子
 * @Author: caffebaby
 * @Date: 2020/8/2
 */

public class Solution3 {
    /**
     * 提示：冒泡排序
     */
    public static int minSwaps(int[][] grid) {
        List<Integer> rows = new LinkedList<>();//记录每行末尾连续0开始的索引位置
        for (int i = 0; i < grid.length; ++i) {
            int startZero = grid.length;
            while (startZero > 0 && grid[i][startZero - 1] == 0)
                --startZero;
            rows.add(startZero);
        }

        int count = 0;
        for (int i = 0; i < grid.length - 1; ++i) {
            int targetRow = i;
            while (targetRow < grid.length && rows.get(targetRow) > i + 1)
                ++targetRow;
            if (targetRow == grid.length)
                return -1;
            int removed = rows.remove(targetRow);//将targetRow位置的元素放置到i处
            rows.add(i, removed);
            count += targetRow - i;//需要操作的次数
            System.out.println(rows);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{0, 0, 1}, {1, 1, 0}, {1, 0, 0}};//3
        int[][] grid2 = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}};//-1
        int[][] grid3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 1}};//0
        System.out.println(minSwaps(grid1));
        System.out.println(minSwaps(grid2));
        System.out.println(minSwaps(grid3));
    }
}
