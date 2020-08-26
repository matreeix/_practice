package _array._896;

/**
 * @Description: 求数组是否单调
 * @Author: matreeix
 * @Date: 2019/7/27 21:39
 */

public class Solution {
    public static boolean isMonotonic(int[] A) {
        int k = 0;
        while (k < A.length - 1) {
            if (A[k] < A[k + 1]) {
                while (k < A.length - 1) {
                    if (A[k] > A[k + 1]) return false;
                    k++;//索引递增最好放在最后
                }
            } else if (A[k] > A[k + 1]) {
                while (k < A.length - 1) {
                    if (A[k] < A[k + 1]) return false;
                    k++;
                }
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ints1 = {1, 1, 2, 2, 3};
        int[] ints2 = {6, 5, 5, 4, 4};
        int[] ints3 = {1, 1, 1};
        int[] ints4 = {1, 3, 2};
        System.out.println(isMonotonic(ints4));
    }
}
