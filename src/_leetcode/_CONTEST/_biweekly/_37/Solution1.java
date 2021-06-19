package _leetcode._CONTEST._biweekly._37;

import java.util.Arrays;

/**
 * @Description: 5122. 删除某些元素后的数组均值
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * <p>
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 * 提示：
 * <p>
 * 20 <= arr.length <= 1000
 * arr.length 是 20 的 倍数
 * 0 <= arr[i] <= 105
 * @Author: matreeix
 * @Date: 2020/10/18
 */

public class Solution1 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double res = 0.0, sum = 0.0;
        int n = arr.length;
        for (int i = n / 20; i < 19 * n / 20; i++) {
            sum += arr[i];
        }
        return sum / (0.9 * n);
    }
}
