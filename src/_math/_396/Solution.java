package _math._396;

import java.util.Arrays;

/**
 * @Description: 旋转函数
 * @Author: matreeix
 * @Date: 2020/5/15
 */
public class Solution {
    //暴力解法
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        if (len == 0) return 0;
        int res = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            int[] newArr = getRotateArr(i, A);
            for (int j = 0; j < len; j++) {
                tmp += j * newArr[j];
            }
            res = Math.max(res, tmp);
            tmp = 0;
        }
        return res;
    }

    //旋转k个位置得到的数组
    private int[] getRotateArr(int k, int[] arr) {
        int len = arr.length;
        int[] newArr = new int[len];
        if (len == 0) return newArr;
        k = k % arr.length;
        for (int i = 0; i < arr.length; i++) {
            newArr[(i + k) % len] = arr[i];
        }
        return newArr;
    }

    //去掉得到旋转数组的耗时
    public int maxRotateFunction2(int[] A) {
        int len = A.length;
        if (len == 0) return 0;
        int res = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < len; i++) {//旋转i个位置
            for (int j = 0; j < len; j++) {//索引
                tmp += j * A[(j - i) < 0 ? len + (j - i) : (j - i)];
            }
            res = Math.max(res, tmp);
            tmp = 0;
        }
        return res;
    }

    //找规律
    //F(k+1) = F(k) + S - n * Bk[n-1]
    //S=Sum{Bk}
    public int maxRotateFunction23(int[] A) {
        int len = A.length;
        long sum = 0;//数组的所有元素之和
        int tmp = 0;
        for (int i = 0; i < len; ++i) {
            sum += A[i];
            tmp += i * A[i];//赋初值
        }
        int res = tmp;
        for (int i = len - 1; i >= 0; --i) {//Bk[n-1]随着k递增其实就是原数组的逆序
            // F(k+1) = F(k) + S - n * Bk[n-1]
            tmp += sum - len * (long) A[i];
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 3, 2, 6};
        System.out.println(solution.maxRotateFunction2(arr));
    }
}
