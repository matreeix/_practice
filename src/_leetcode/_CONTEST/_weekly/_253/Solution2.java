package _leetcode._CONTEST._weekly._253;

import java.util.PriorityQueue;

/**
 * @Description: 5839. 移除石子使总数最小
 * 给你一个整数数组 piles ，数组 下标从 0 开始 ，其中 piles[i] 表示第 i 堆石子中的石子数量。另给你一个整数 k ，请你执行下述操作 恰好 k 次：
 * 选出任一石子堆 piles[i] ，并从中 移除 floor(piles[i] / 2) 颗石子。
 * 注意：你可以对 同一堆 石子多次执行此操作。
 * 返回执行 k 次操作后，剩下石子的 最小 总数。
 * <p>
 * floor(x) 为 小于 或 等于 x 的 最大 整数。（即，对 x 向下取整）。
 * 提示：
 * <p>
 * 1 <= piles.length <= 10^5
 * 1 <= piles[i] <= 10^4
 * 1 <= k <= 10^5
 * @Date: 2021/8/8
 */

public class Solution2 {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) p.add(pile);
        while (k > 0) {
            int tmp = p.poll();
            p.add((tmp + 1) / 2);
            k--;
        }
        int res = 0;
        while (p.size() > 0) {
            res += p.poll();
        }
        return res;
    }

    int MAX_VAL = 10000;

    public int minArraySum2(int[] nums, int k) {
        int[] f = new int[MAX_VAL + 1];
        for (int x : nums) f[x]++;
        for (int v = MAX_VAL; v >= 1 && k > 0; v--) {
            while (f[v] > 0 && k > 0) {
                int newv = (v + 1) / 2;
                f[v]--;
                f[newv]++;
                k--;
            }
        }
        int ans = 0;
        for (int v = 1; v <= MAX_VAL; v++) ans += v * f[v];
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = {5, 4, 9};
        int k = 2;
        System.out.println(minStoneSum(piles, k));
    }
}
