package _leetcode._CONTEST._biweekly._39;

import java.util.*;

/**
 * @Description: 1655. 分配重复整数
 * 给你一个长度为 n 的整数数组 nums ，这个数组中至多有 50 个不同的值。同时你有 m 个顾客的订单 quantity ，
 * 其中，整数 quantity[i] 是第 i 位顾客订单的数目。请你判断是否能将 nums 中的整数分配给这些顾客，且满足：
 * <p>
 * 第 i 位顾客 恰好 有 quantity[i] 个整数。
 * 第 i 位顾客拿到的整数都是 相同的 。
 * 每位顾客都满足上述两个要求。
 * 如果你可以分配 nums 中的整数满足上面的要求，那么请返回 true ，否则返回 false 。
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= 1000
 * m == quantity.length
 * 1 <= m <= 10
 * 1 <= quantity[i] <= 10^5
 * nums 中至多有 50 个不同的数字。
 * @Author: matreeix
 * @Date: 2020/11/14
 */

public class Solution4 {
    public boolean canDistribute(int[] dist, int[] quantity) {

//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int num : nums)
//            freq.put(num, freq.getOrDefault(num, 0) + 1);
//
//        int[] dist = new int[freq.size()];
//        int idx = 0;
//        for (int f : freq.values())
//            dist[idx++] = f;

        Arrays.sort(quantity);
        Arrays.sort(dist);
        return rec(dist, quantity, quantity.length - 1);
    }

    // try to fullfill the j-th order quantity
    private boolean rec(int[] dist, int[] quantity, int j) {
        // stop condition. We've fulfilled all the order quantities.
        if (j == -1)
            return true;

        Set<Integer> used = new HashSet<>();
        for (int i = dist.length - 1; i > 0; i--) {
            // Use a set to make sure that
            // we don't distribute from the same amount to this j-th order for more than once.
            // With this check, the program reduces from 97ms to 25 ms.
            if (dist[i] >= quantity[j] && used.add(dist[i])) {
                dist[i] -= quantity[j];
                if (rec(dist, quantity, j - 1))
                    return true;
                dist[i] += quantity[j];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] dist = {10, 2, 2, 1};
        int[] quality = {5, 4, 1};
        Solution4 s= new Solution4();
        System.out.println(s.canDistribute(dist,quality));
    }
}
