package _leetcode._math._1492;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: n的第k个因子
 * <p>
 * 给你两个正整数 n 和 k 。
 * 如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n 的因子。
 * 考虑整数 n 的所有因子，将它们 升序排列 。请你返回第 k 个因子。如果 n 的因子数少于 k ，请你返回 -1 。
 * @Author: matreeix
 * @Date: 2020/7/6
 */

public class Solution {
    public int kthFactor(int n, int k) {
        int sqrt = (int) Math.sqrt(n);
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0)
                factors.add(i);
        }

        if (k <= factors.size()) {
            return factors.get(k - 1);
        } else if (k <= 2 * factors.size() - 1) {
            return n / (factors.get(2 * factors.size() - k));
        } else {
            if (sqrt * sqrt != n && k == 2 * factors.size())
                return n;
            return -1;
        }
    }

    public int kthFactor2(int n, int k) {
        int d = 1;
        for (; d * d <= n; ++d)
            if (n % d == 0 && --k == 0)
                return d;
        for (d = d - 1; d >= 1; --d) {
            if (d * d == n)
                continue;
            if (n % d == 0 && --k == 0)
                return n / d;
        }
        return -1;
    }

    public int kthFactor3(int n, int k) {

        if (n == 1 || k == 1)
            return 1;
        if (k > n / 2 + 1)
            return -1;

        int mid = 0;
        // 60 : 30 20 15
        if (n % 2 == 0)
            // 偶数：1 2
            mid = n / 2;
        else
            // 基数
            mid = n / 2 + 1;

        int count = 2;
        for (int i = 2; i <= mid; i++)
            if (n % i == 0 && k == count++)
                return i;

        if (count == k)
            return n;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).kthFactor(12, 3));
        System.out.println((new Solution()).kthFactor(1000, 5));
        System.out.println((new Solution()).kthFactor(1000, 11));
        System.out.println((new Solution()).kthFactor(7, 2));
        System.out.println((new Solution()).kthFactor(4, 4));
    }
}
