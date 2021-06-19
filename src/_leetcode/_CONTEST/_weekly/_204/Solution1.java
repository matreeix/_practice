package _leetcode._CONTEST._weekly._204;

/**
 * @Description: 5499. 重复至少 K 次且长度为 M 的模式
 * 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 * 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
 * 如果数组中存在一个至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 * @Author: matreeix
 * @Date: 2020/8/30
 */

public class Solution1 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        if (m * k > n) return false;
        int cnt = 0;
        for (int i = 0; i < n - m; i++) {
            if (arr[i] == arr[i + m])
                cnt++;
            else
                cnt = 0;
            if (cnt == m * (k - 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
