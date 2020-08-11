package _other._566;

import java.util.Arrays;

/**
 * @Description: 将m*n数组按照原序列变成r*c数组
 * @Author: caffebaby
 * @Date: 2019/7/26 21:04
 */
public class Solution {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;//行数
        int n = nums[0].length;//列数
        if (r * c != m * n) return nums;
        int[][] new_nums = new int[r][c];

        //考察顺数第k个元素，k = i * m + j = x * r + y（j < n,y < c）
        new_nums[0][0] = nums[0][0];
        int k = 1;
        while (k <= r * c) {
            int i1 = k / n;
            int j1 = k % n;
            int i2 = k / c;
            int j2 = k % c;
            if (k % n == 0 && k % c != 0) {//nums的行尾元素
                new_nums[i2][j2 - 1] = nums[i1 - 1][n - 1];
            } else if (k % n != 0 && k % c == 0) {//new_//nums的行尾元素
                new_nums[i2 - 1][c - 1] = nums[i1][j1 - 1];
            } else if (k % n == 0 && k % c == 0) {//两者都是行尾元素
                new_nums[i2 - 1][c - 1] = nums[i1 - 1][n - 1];
            } else {
                new_nums[i2][j2 - 1] = nums[i1][j1 - 1];
            }
            k++;
        }

        return new_nums;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2},
                {3, 4},
                {5, 6}};//nums[1][0]==new_nums[0][2];
        System.out.println(Arrays.toString(matrixReshape(ints, 2, 3)[1]));
    }
}
