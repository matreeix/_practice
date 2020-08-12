package _graph._733;

import java.util.Arrays;

/**
 * @Description:Flood Fill(给图片染色)
 * @Author: matreeix
 * @Date: 2020/2/14
 */
public class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R, C;
    private boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || sr < 0 || sc < 0) return image;
        R = image.length;
        C = image[0].length;
        visited = new boolean[R][C];
        int oldColor = image[sr][sc];//旧的颜色

        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        visited[x][y] = true;
        image[x][y] = newColor;
        for (int d = 0; d < 4; d++) {
            int nextx = x + dirs[d][0], nexty = y + dirs[d][1];
            if (inArea(nextx, nexty) && image[nextx][nexty] == oldColor && !visited[nextx][nexty])
                dfs(image, nextx, nexty, oldColor, newColor);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        System.out.println(Arrays.deepToString((new Solution()).floodFill(image, sr, sc, newColor)));

    }

}
