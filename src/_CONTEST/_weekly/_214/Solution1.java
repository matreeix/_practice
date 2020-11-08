package _CONTEST._weekly._214;

/**
 * @Description: 5561. 获取生成数组中的最大值
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * 1.nums[0] = 0
 * 2.nums[1] = 1
 * 3.当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 4.当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * 0 <= n <= 100
 * @Author: matreeix
 * @Date: 2020/11/8
 */

public class Solution1 {
    //暴力,O(n)
    public int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 0;
        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) arr[i] = arr[i / 2];
            else arr[i] = arr[i / 2] + arr[i / 2 + 1];
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
