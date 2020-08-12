package _CONTEST._biweekly._32;

/**
 * @Description: 5468. 第 k 个缺失的正整数
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * @Author: matreeix
 * @Date: 2020/8/8
 */

public class Solution1 {
    //暴力解法
    public static int findKthPositive(int[] arr, int k) {
        int idx = 0;
        for (int i = 1; i < 3000; i++) {
            if (idx < arr.length && arr[idx] == i) {
                idx++;
            } else {
                k--;
            }
            if (k == 0) return i;
        }
        return -1;
    }

    //二分搜索
    public static int findKthPositive2(int[] A, int k) {
        int l = 0, r = A.length, m;
        while (l < r) {
            m = (l + r + 1) / 2;
            if (m == 0 || A[m - 1] - m < k)//左边界
                l = m;
            else//A[m - 1] - m >= k,右边界
                r = m - 1;
        }
        return l + k;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 1;
        System.out.println(findKthPositive2(arr, k));
    }
}
