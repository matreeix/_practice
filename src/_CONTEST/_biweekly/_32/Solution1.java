package _CONTEST._biweekly._32;

/**
 * @Description: 5468. 第 k 个缺失的正整数
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * @Author: Pythagodzilla
 * @Date: 2020/8/8
 */

public class Solution1 {
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


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
}
