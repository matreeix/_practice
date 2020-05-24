package _array._162;

/**
 * @Description: 寻找峰值
 * <p>
 * 问题描述：峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 扩展：在二维情况下，即在矩阵中寻找极小值。
 * @Author: 67ng
 * @Date: 2020/5/24
 */
public class Solution {
    //时间复杂度O(log n)
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    //时间复杂度O(n * log n),matrix为 n*n 的矩阵
    public static int[] findMinVal(int[][] matrix) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int min = getMin(matrix[mid]);
            if (matrix[mid][min] > matrix[mid + 1][min])
                l = mid + 1;
            else
                r = mid;
        }
        int x = l;
        int y = getMin(matrix[l]);
        return new int[]{x, y};
    }

    //返回数组的最小值的索引
    private static int getMin(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[res] >= arr[i])
                res = i;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
//        int[] nums = {1, 2, 1, 3, 5, 6, 7};
//        System.out.println(findPeakElement(nums));
//        int[] arr = {2, 1, 3, -1, 7, 5};
//        System.out.println(getMin(arr));
        int[][] matrix = {{9, 1, 8},
                {7, 5, 6},
                {2, 3, 4}};
        System.out.println(findMinVal(matrix)[0]);
        System.out.println(findMinVal(matrix)[1]);
    }

}