package _Cracking_the_Coding_Interview._16._16;

import java.util.Arrays;

/**
 * @Description: 面试题 16.16. 部分排序
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * 提示：
 * <p>
 * 0 <= len(array) <= 1000000
 * @Author: matreeix
 * @Date: 2020/11/13
 */

public class Solution {
    //暴力排序法
    public static int[] subSort(int[] array) {
        int[] tmp = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        int m = -1;
        int n = array.length;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != array[i]) {
                m = i;
                break;
            }
        }
        if (m == -1) return new int[]{-1, -1};
        for (int i = n - 1; i > 0; i--) {
            if (tmp[i] != array[i]) {
                n = i;
                break;
            }
        }
        return new int[]{m, n};
    }
    public static int[] subSort2(int[] array) {
        int[] res = {-1, -1};
        if (array.length == 0) return res;
        int max = array[0];
        int min = array[array.length - 1];
        int r = -1;
        int l = -1;
        for (int i = 1; i < array.length; i++)//从左往右扫
            if (array[i] < max) r = i;
            else max = array[i];

        if (r == -1) return res;//初始就是有序

        for (int i = array.length - 2; i >= 0; i--)//从右往左扫
            if (array[i] > min) l = i;
            else min = array[i];

        res[0] = l;
        res[1] = r;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 7, 8,9};
        System.out.println(Arrays.toString(subSort2(arr)));
    }
}
