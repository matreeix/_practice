package _math._397;

/**
 * @Description: 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * 1.如果 n 是偶数，则用 n / 2替换 n 。
 * 2.如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * @Created by: matreeix
 * @Date: 2021/5/24
 */
public class Solution {
    public int integerReplacement(int n) {
        return (int) func((long) n);
    }

    public long func(long n) {
        if (n == 1) return 0;
        if (n % 2 == 0) {
            return 1 + func(n / 2);
        } else {
            return 1 + Math.min(func(n + 1), func(n - 1));
        }
    }

    public int integerReplacement2(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        if (n <= 3) return n - 1;//这是特殊情况，特殊处理

        if (n % 2 == 0) return integerReplacement2(n / 2) + 1;
        if (n % 4 == 1)
            return integerReplacement2(n - 1) + 1;
        else
            return integerReplacement2(n + 1) + 1;
    }

}
