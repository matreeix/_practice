package _leetcode._CONTEST._weekly._222;

/**
 * @Description: 5643. 将数组分成三个子数组的方案数
 * 我们称一个分割整数数组的方案是 好的 ，当它满足：
 * 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
 * left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
 * 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
 * @Date: 2021/1/3
 */

public class Solution3 {
    //三指针
    public static int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        final int MOD = 1000000007;
        long ans = 0;
        // |______|________|_______|________|
        // 1      i        l       r        n
        // i 表示第一刀的位置，枚举第一刀的位置，计算第二刀的可选位置数
        for (int i = 1, l = 2, r = 2; sum[i] <= sum[n] / 3 && i < n; i++) {
            l = Math.max(l, i + 1);
            r = Math.max(r, i + 1);
            // sum(right) >= sum(mid)，r最大为n-1，right保证要有一个数
            while (r <= n - 1 && sum[n] - sum[r] >= sum[r] - sum[i]) {
                r++;
            }

            // sum(mid) >= sum(left)
            while (l <= n - 1 && sum[l] - sum[i] < sum[i]) {
                l++;
            }
            if (l <= r) {
                ans += r - l;
            }
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        System.out.println(waysToSplit(arr));
    }

}