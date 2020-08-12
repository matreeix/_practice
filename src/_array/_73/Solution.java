package _array._73;

import java.util.Arrays;

/**
 * @Description: 将二维数组有0元素的行列元素全部置为0
 * @Author: matreeix
 * @Date: 2020/1/9 22:05
 */
public class Solution {
    public static void setZeroes(int[][] matrix) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {
            return;
        }
        /**矩阵左上角的元素，赋个不为0的初值
         *这个元素单独处理是因为例如：
         * 第一列有0元素会将其置为0，
         * 但第一行的元素都不为0，
         * 这样会将其他元素全部抹去
         * 例：
         * {{1, 1, 1},
         *  {0, 1, 2}};
         *
         * */
        int col0 = 1;//

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                //遍历矩阵，将为零元素的行列分别存储在第一行和第一列对应位置
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;//不要忘记！
        }
    }

    public static void main(String[] args) {
        int[][] ints = {
                {0, 1, 2, 0},
                {3, 4, 0, 2},
                {1, 3, 1, 5}
        };

        setZeroes(ints);
        System.out.println(Arrays.deepToString(ints));

    }
}
