package _search._378;

/**
 * @Description: 378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 提示：
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n^2
 * @Created by: matreeix
 * @Date: 2021/5/7
 */
public class Solution {
    //二分查找，时间复杂度O(N * log(max-min))
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //检查在矩阵中是否是第k大
    public boolean check(int[][] matrix, int mid, int k, int n) {
        //从矩阵左下角出发
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {//从上走出边界为止
            if (matrix[i][j] <= mid) {
                num += i + 1;//统计比mid的元素个数
                j++;//向右走
            } else {
                i--;//向上走
            }
        }
        return num >= k;
    }
}
