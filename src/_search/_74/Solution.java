package _search._74;

/**
 * @Description: 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 1.每行中的整数从左到右按升序排列。
 * 2.每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * @Date: 2021/3/31
 */

public class Solution {

    //二维的二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] > target)
                r = mid - 1;
            else if (matrix[mid][0] < target)
                l = mid + 1;
            else
                return true;
        }
        if (l < 0 || l > matrix.length - 1) l = r;
        int mark = matrix[l][0] > target ? l - 1 : l;
        int ll = 0, rr = matrix[0].length - 1;
        if (mark < 0 || mark > matrix.length) return false;
        while (ll < rr) {
            int mid = ll + (rr - ll) / 2;
            if (matrix[mark][mid] > target)
                rr = mid - 1;
            else if (matrix[mark][mid] < target)
                ll = mid + 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{-9, -8, -8, -8}, {-7, -6, -5, -5}, {-3, -1, 0, 0}, {2, 3, 4, 5}, {7, 7, 7, 7}, {9, 9, 10, 10}};
        System.out.println(searchMatrix(matrix, 10));
    }
}
