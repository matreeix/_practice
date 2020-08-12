package _other._566;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2019/7/26 22:34
 */
public class Solution2 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] reshaped = new int[r][c];
        int k = 0, l = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = nums[i][j];
                reshaped[k][l++] = num;//将原数组的元素一个个取出来填进新数组
                if (l == c) {           //beautiful！
                    k++;
                    l = 0;
                }
            }
        }
        return reshaped;
    }
}
