
package _leetcode._bit_calc._201;

/**
 * @Description: 201. 数字范围按位与
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * 提示：
 * 0 <= left <= right <= 2^31 - 1
 * @Date: 2021/4/10
 */

public class Solution {
    /**
     * 1. n & (n + 1) = n,n为偶数
     * 2. 2^n & (2^n+1)&....&(2^(n+1)-1) = 2^n
     * 3. 2^n & 2^(n+1) = 0
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    //Brian Kernighan 算法
    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(2 & 2);
    }

}
