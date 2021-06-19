package _leetcode._Cracking_the_Coding_Interview._16._21;

import java.util.Arrays;

/**
 * @Description: 面试题 16.21. 交换和
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 * 若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * @Author: matreeix
 * @Date: 2020/12/4
 */

public class Solution {
    public static int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;

        for (int n : array1)
            sum1 += n;
        for (int n : array2)
            sum2 += n;
        if ((sum1 - sum2) % 2 != 0 || sum1 - sum2 == 0) return new int[]{};
        int diff = (sum1 - sum2) / 2;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length)
            if (array1[i] - array2[j] == diff) return new int[]{array1[i], array2[j]};
            else if (array1[i] - array2[j] < diff) i++;
            else j++;
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        System.out.println(Arrays.toString(findSwapValues(arr1, arr2)));
    }
}
