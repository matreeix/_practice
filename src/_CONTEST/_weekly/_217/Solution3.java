package _CONTEST._weekly._217;

import java.util.Arrays;

/**
 * @Description: 1674. 使数组互补的最少操作次数
 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。
 * 例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
 * 返回使数组 互补 的 最少 操作次数。
 * 1 <= nums[i] <= limit <= 10^5
 * @Author: matreeix
 * @Date: 2020/12/1
 */

public class Solution3 {
    /**
     * 差分数组
     * 作者：lucifer1004
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary/solution/chai-fen-sao-miao-by-lucifer1004/
     * */
    public int minMoves(int[] nums, int limit) {
        int[] delta = new int[2 * limit + 2];
        Arrays.fill(delta, 0);
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            delta[2] += 2;
            delta[Math.min(a, b) + 1]--;
            delta[a + b]--;
            delta[a + b + 1]++;
            delta[Math.max(a, b) + limit + 1]++;
        }
        int res = 2 * n, curr = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            curr += delta[i];
            res = Math.min(res, curr);
        }
        return res;
    }
}
