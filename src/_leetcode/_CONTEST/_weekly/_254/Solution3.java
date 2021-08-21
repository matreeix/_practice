package _leetcode._CONTEST._weekly._254;


/**
 * @Description: 5844. 数组元素的最小非零乘积
 * 给你一个正整数 p 。你有一个下标从 1 开始的数组 nums ，这个数组包含范围 [1, 2^p - 1] 内所有整数的二进制形式（两端都 包含）。你可以进行以下操作 任意 次：
 * 从 nums 中选择两个元素 x 和 y  。
 * 选择 x 中的一位与 y 对应位置的位交换。对应位置指的是两个整数 相同位置 的二进制位。
 * 比方说，如果 x = 1101 且 y = 0011 ，交换右边数起第 2 位后，我们得到 x = 1111 和 y = 0001 。
 * 请你算出进行以上操作 任意次 以后，nums 能得到的 最小非零 乘积。将乘积对 10^9 + 7 取余 后返回。
 * 注意：答案应为取余 之前 的最小值。
 * 提示：
 * 1 <= p <= 60
 * @Date: 2021/8/15
 */

public class Solution3 {
    private long MOD = (long) (1e9 + 7);

    public int minNonZeroProduct(int p) {
        long max_num = (1L << p) - 1;

        long x = max_num - 1;
        long n = (1L << (p - 1)) - 1;

        long res = max_num % MOD * quick_mul(x, n) % MOD;
        return (int) res;
    }

    public long quick_mul(long x, long n) {
        x %= MOD;
        long res = 1L;
        while (n > 0) {
            if ((n & 1) != 0)
                res = (res * x) % MOD;
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }

}