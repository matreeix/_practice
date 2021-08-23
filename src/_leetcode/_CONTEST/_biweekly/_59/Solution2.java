package _leetcode._CONTEST._biweekly._59;

/**
 * @Description: 5835. 最大方阵和
 * 给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
 * 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
 * 如果两个元素有 公共边 ，那么它们就是 相邻 的。
 * 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。
 * 提示：
 * n == matrix.length == matrix[i].length
 * 2 <= n <= 250
 * -10^5 <= matrix[i][j] <= 10^5
 * @Date: 2021/8/21
 */

public class Solution2 {

    public static long maxMatrixSum(int[][] matrix) {
        long sum = 0, min = 1000001, cnt = 0;
        int n = matrix.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
                min = Math.min(Math.abs(matrix[i][j]) == 0 ? min : Math.abs(matrix[i][j]), min);
                if (matrix[i][j] < 0) cnt++;
                if (matrix[i][j] == 0) flag = true;
            }
        }
        return cnt % 2 == 0 || flag ? sum : sum - 2 * min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-1, 0, -1}, {-2, 1, 3}, {3, 2, 2}};
        System.out.println(maxMatrixSum(matrix));
    }
}
