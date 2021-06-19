package _leetcode._CONTEST._weekly._221;


import java.util.Arrays;

/**
 * @Description: 1706. 球会落何处
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 * @Date: 2020/12/29
 */

public class Solution3 {
    public static int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[j] != -1) {//-1是已经被挡住的小球
                    int idx = res[j];
                    if (idx == 0 && grid[i][idx] == -1) res[j] = -1;//左边界挡住
                    else if (idx == n - 1 && grid[i][idx] == 1) res[j] = -1;//右边界挡住
                    else if (grid[i][idx] == 1 && grid[i][idx + 1] == 1) res[j] += 1;//右移
                    else if (grid[i][idx] == -1 && grid[i][idx - 1] == -1) res[j] -= 1;//左移
                    else res[j] = -1;//中间卡住
                }
            }
//            System.out.println(Arrays.toString(res));
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1, 1, 1, -1, -1},
//                {1, 1, 1, -1, -1},
//                {-1, -1, -1, 1, 1},
//                {1, 1, 1, 1, -1},
//                {-1, -1, -1, -1, -1}};
        int[][] grid ={{-1}};
        System.out.println(Arrays.toString(findBall(grid)));
    }
}
