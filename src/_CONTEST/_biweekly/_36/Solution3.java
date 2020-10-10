package _CONTEST._biweekly._36;

/**
 * @Description: 5518. 给定行和列的和求可行矩阵
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。
 * 换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 * <p>
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 * <p>
 * 提示：
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 108
 * sum(rows) == sum(columns)
 * @Author: matreeix
 * @Date: 2020/10/3
 */

public class Solution3 {
   //贪心，妙啊
    public int[][] restoreMatrix(int[] row, int[] col) {
        int m = row.length, n = col.length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i][j] = Math.min(row[i], col[j]);//取两者的最小值可以保证后面得到的元素不小于0
                row[i] -= A[i][j];
                col[j] -= A[i][j];
            }
        }
        return A;
    }
}
