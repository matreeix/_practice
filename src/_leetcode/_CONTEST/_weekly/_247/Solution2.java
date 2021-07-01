package _leetcode._CONTEST._weekly._247;

/**
 * @Description: 5798. 循环轮转矩阵
 * 给你一个大小为 m x n 的整数矩阵 grid​​​ ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。
 * 矩阵由若干层组成，如下图所示，每种颜色代表一层：
 * 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
 * 返回执行 k 次循环轮转操作后的矩阵。
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * m 和 n 都是 偶数
 * 1 <= grid[i][j] <= 5000
 * 1 <= k <= 10^9
 * @Date: 2021/6/27
 */

public class Solution2 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int bottom = grid.length - 1, right = grid[0].length - 1;//Bottom right coordinates
        int top = 0, left = 0;//Top left coordinates
        while (bottom > top && right > left) {
            int total_layer_elements = 2 * (bottom - top + 1) + 2 * (right - left + 1) - 4;//每层的元素总数
            int t = k % total_layer_elements;//实际需要移动的步数
            while (t-- > 0) {
                int temp = grid[top][left];
                for (int j = left; j < right; j++) {
                    grid[top][j] = grid[top][j + 1];
                }
                for (int i = top; i < bottom; i++) {
                    grid[i][right] = grid[i + 1][right];
                }
                for (int j = right; j > left; j--) {
                    grid[bottom][j] = grid[bottom][j - 1];
                }
                for (int i = bottom; i > top; i--) {
                    grid[i][left] = grid[i - 1][left];
                }
                grid[top + 1][left] = temp;
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return grid;
    }
}

