package _array._922;

import java.util.Arrays;

/**
 * @Description: 按奇偶校验排序数组
 * <p>
 * 给定一个A 非负整数数组，A中一半的整数是奇数，而一半的整数是偶数。
 * 对数组进行排序，以使每当A[i]为奇数时i为奇数；每当A[i]为偶数，i为偶数。
 * @Author: caffebaby
 * @Date: 2020/3/8
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] oddArr = new int[A.length];//记录奇数位置错误的索引
        int[] evenArr = new int[A.length];//记录偶数位置错误的索引
        int odd = 0, even = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] % 2 != 0)
                evenArr[even++] = i;
            else if (i % 2 == 1 && A[i] % 2 != 1)
                oddArr[odd++] = i;
        }
        for (int i = 0; i < A.length; i++) {
            if (oddArr[i] == 0) break;
            swap(A, oddArr[i], evenArr[i]);
        }
        return A;
    }

    //Two Pointer
    public int[] sortArrayByParityII2(int[] A) {
        int i = 0, j = 1, len = A.length;
        while (i < len && j < len) {
            while (i < len && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < len && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < len && j < len) {
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 1};
        (new Solution()).sortArrayByParityII(arr);
        System.out.println(Arrays.toString(arr));
    }
}
