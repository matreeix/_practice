package _Cracking_the_Coding_Interview._16._19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 面试题 16.19. 水域大小
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * @Author: matreeix
 * @Date: 2020/12/3
 */

public class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private boolean[][] visited;
    private int R;
    private int C;

    public int[] pondSizes(int[][] land) {
        R = land.length;
        C = land[0].length;
        visited = new boolean[R][C];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    res.add(dfs(i, j, land));
                }
            }
        }
        int[] nums = res.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(nums);
        return nums;
    }

    private int dfs(int x, int y, int[][] land) {
        visited[x][y] = true;
        int num = 1;
        for (int i = 0; i < dirs.length; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (intArea(newX, newY) && !visited[newX][newY] && land[newX][newY] == 0)
                num += dfs(newX, newY, land);
        }
        return num;
    }

    private boolean intArea(int x, int y) {
        return 0 <= x && x <= R - 1 && 0 <= y && y <= C - 1;
    }

    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}};
        Solution s = new Solution();
        int[] res = s.pondSizes(land);
        System.out.println(Arrays.toString(res));
    }
}
