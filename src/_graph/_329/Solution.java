package _graph._329;

/**
 * @Description: 矩阵中最长的增长路径
 * @Author: caffebaby
 * @Date: 2020/3/9
 */
public class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R, C;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        R = matrix.length;
        C = matrix[0].length;
        int[][] len = new int[R][C];//记录每个元素开始的最长路径

        int max = 1;
        for (int i = 0; i < R * C; i++) {
            int length = dfs(matrix, i, len);
            max = Math.max(max, length);
        }
        return max;
    }

    private int dfs(int[][] matrix, int index, int[][] len) {//得到一个点的最长路径
        int curx = index / C, cury = index % C;
        if (len[curx][cury] != 0) return len[curx][cury];
        int max = 1;
        for (int d = 0; d < 4; d++) {
            int nextx = curx + dirs[d][0];
            int nexty = cury + dirs[d][1];
            if (!inArea(nextx, nexty) || matrix[curx][cury] >= matrix[nextx][nexty])
                continue;
            int length = 1 + dfs(matrix, nextx * C + nexty, len);
            max = Math.max(max, length);
        }
        len[curx][cury] = max;
        return max;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}


