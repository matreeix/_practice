package _leetcode._CONTEST._weekly._248;

import _leetcode._array._498.Solution;

/**
 * @Description: 5802. 统计好数字的数目
 * 我们称一个数字字符串是 好数字 当它满足（下标从 0 开始）偶数 下标处的数字为 偶数 且 奇数 下标处的数字为 质数 （2，3，5 或 7）。
 * 比方说，"2582" 是好数字，因为偶数下标处的数字（2 和 8）是偶数且奇数下标处的数字（5 和 2）为质数。但 "3245" 不是 好数字，因为 3 在偶数下标处但不是偶数。
 * 给你一个整数 n ，请你返回长度为 n 且为好数字的数字字符串 总数 。由于答案可能会很大，请你将它对 109 + 7 取余后返回 。
 * 一个 数字字符串 是每一位都由 0 到 9 组成的字符串，且可能包含前导 0 。
 * 提示：
 * 1 <= n <= 10^15
 * @Date: 2021/7/4
 */

public class Solution3 {
    public int countGoodNumbers(long n) {
        long res = 0, mod = 1000000007;
        long odd = 0, even = 0;
        odd = n / 2;
        even = n - odd;
        res = (qmi(5, even, mod) * qmi(4, odd, mod)) % mod;
        return (int) res;
    }

    public long qmi(long a, long k, long p) {
        long res = 1 % p, t = a;
        while (k > 0) {
            if ((k & 1) == 1) res = res * t % p;
            t = t * t % p;
            k >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.countGoodNumbers(4));
        System.out.println(s.countGoodNumbers(1));
        System.out.println(s.countGoodNumbers(50));
    }
}
