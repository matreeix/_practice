package _leetcode._CONTEST._biweekly._34;

/**
 * @Description: 5493. 删除最短的子数组使剩余数组有序
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * 一个子数组指的是原数组中连续的一个子序列。
 * 请你返回满足题目要求的最短子数组的长度。
 * @Author: matreeix
 * @Date: 2020/9/5
 */

public class Solution3 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while (left + 1 < arr.length && arr[left] <= arr[left + 1]) left++;
        if (left == arr.length - 1) return 0;

        int right = arr.length - 1;
        while (right > left && arr[right - 1] <= arr[right]) right--;
        int result = Math.min(arr.length - left - 1, right);

        int i = 0;
        int j = right;
        while (i <= left && j < arr.length) {
            if (arr[j] >= arr[i]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}

