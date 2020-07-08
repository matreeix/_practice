package _array._1287;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 有序数组中元素个数超过1/4
 * <p>
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数。
 * @Author: Pythagodzilla
 * @Date: 2020/7/8
 */

public class Solution {

    //O(n)
    public static int findSpecialInteger(int[] arr) {
        int len = arr.length;
        for (int i = 0, j = 0; i < len; i = j) {
            while (j < len && arr[i] == arr[j]) j++;
            if (j - i > len / 4) return arr[i];
        }
        return -1;
    }

    //时间最优解法,O(n)
    public int findSpecialInteger2(int[] arr) {
        int n = arr.length, t = n / 4;

        for (int i = 0; i < n - t; i++) {
            if (arr[i] == arr[i + t]) {
                return arr[i];
            }
        }
        return -1;
    }

    //O(log n),运用二分搜索妙啊！
    public int findSpecialInteger3(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        //需要找到的元素必然是下面三个值之一
        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n / 4], arr[n / 2], arr[(3 * n) / 4]));
        for (int element : list) {
            int left = binarySearch(arr, element);
            int right = binarySearch(arr, element + 1);//加一，很细节。
            if ((right - left) > n / 4)
                return element;
        }
        return -1;
    }

    //该二分查找会返回target的左边界
    private int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] < target)
                low = middle + 1;
            else
                high = middle;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int[] arr2 = {6, 6, 6, 1};
        int[] arr3 = {1, 2, 2, 6, 6, 6, 6, 6};
        System.out.println(findSpecialInteger(arr1));
        System.out.println(findSpecialInteger(arr2));
        System.out.println(findSpecialInteger(arr3));
    }

}
