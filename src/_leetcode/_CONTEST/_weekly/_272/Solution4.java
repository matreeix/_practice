package _leetcode._CONTEST._weekly._272;

import java.util.Arrays;

/**
 * @Description: 5959. 使数组 K 递增的最少操作次数
 * 给你一个下标从 0 开始包含 n 个正整数的数组 arr ，和一个正整数 k 。
 * 如果对于每个满足 k <= i <= n-1 的下标 i ，都有 arr[i-k] <= arr[i] ，那么我们称 arr 是 K 递增 的。
 * 1.比方说，arr = [4, 1, 5, 2, 6, 2] 对于 k = 2 是 K 递增的，因为：
 * arr[0] <= arr[2] (4 <= 5)
 * arr[1] <= arr[3] (1 <= 2)
 * arr[2] <= arr[4] (5 <= 6)
 * arr[3] <= arr[5] (2 <= 2)
 * 2.但是，相同的数组 arr 对于 k = 1 不是 K 递增的（因为 arr[0] > arr[1]），对于 k = 3 也不是 K 递增的（因为 arr[0] > arr[3] ）。
 * 每一次 操作 中，你可以选择一个下标 i 并将 arr[i] 改成任意 正整数。
 * 请你返回对于给定的 k ，使数组变成 K 递增的 最少操作次数 。
 * 提示：
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i], k <= arr.length
 * @Date: 2021/12/19
 */

public class Solution4 {
    public int kIncreasing(int[] arr, int k) {
        int res = 0;
        int n = arr.length;
        int len = n / k + 1;
        for (int i = 0; i < k; i++) {
            int[] tmp = new int[len];
            Arrays.fill(tmp, n + 1);
            int idx = 0;
            for (int j = i; j < arr.length; j += k) {
                tmp[idx++] = arr[j];
            }
            res += tmp.length - lengthOfLIS(tmp);
        }
        return res;
    }

    private int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] <= num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};
        System.out.println((new Solution4()).lengthOfLIS(nums));
    }
}
