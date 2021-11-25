package _leetcode._CONTEST._weekly._268;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 2081. k 镜像数字的和
 * 一个 k 镜像数字 指的是一个在十进制和 k 进制下从前往后读和从后往前读都一样的 没有前导 0 的 正 整数。
 * 比方说，9 是一个 2 镜像数字。9 在十进制下为 9 ，二进制下为 1001 ，两者从前往后读和从后往前读都一样。
 * 相反地，4 不是一个 2 镜像数字。4 在二进制下为 100 ，从前往后和从后往前读不相同。
 * 给你进制 k 和一个数字 n ，请你返回 k 镜像数字中 最小 的 n 个数 之和 。
 * @Date: 2021/11/23
 */

public class Solution4 {
    public boolean ispal(long num, int base) {
        long mul = 1;
        while (mul * base <= num)
            mul *= base;
        for (; num != 0; mul /= (long) base * base) {
            if (num / mul != num % base)
                return false;
            num = (num - (num / mul) * mul - num % base) / base;
        }
        return true;
    }

    public long kMirror(int k, int n) {
        long ans = 0;
        for (int len = 1; ; len++) {
            int l = (int) Math.pow(10, (len - 1) / 2);
            int r = (int) Math.pow(10, (len + 1) / 2);

            for (int i = l; i < r; i++) {
                long b = i;
                for (int j = len % 2 == 1 ? i / 10 : i; j > 0; j /= 10) {
                    b = b * 10 + j % 10;
                }
                if (ispal(b, k)) {
                    ans += b;
                    if (--n == 0) {
                        return ans;
                    }
                }
            }
        }
    }

    //检查是否回文串
    private static boolean isPalindromeStr(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 检查是否回文数
    public static boolean isPalindromeNum(long x) {
        if (x % 10 == 0) return false;
        long reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10L + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        List<Long> list2 = new ArrayList<>();
        List<Long> list3 = new ArrayList<>();
        List<Long> list4 = new ArrayList<>();
        List<Long> list5 = new ArrayList<>();
        List<Long> list6 = new ArrayList<>();
        List<Long> list7 = new ArrayList<>();
        List<Long> list8 = new ArrayList<>();
        List<Long> list9 = new ArrayList<>();

        long MAX = 100_000_000_000L;
        long start = System.currentTimeMillis();

        for (long i = 1; i < MAX; i++) {
            if (isPalindromeNum(i)) {
                String b2 = Long.toString(i, 2);
                String b3 = Long.toString(i, 3);
                String b4 = Long.toString(i, 4);
                String b5 = Long.toString(i, 5);
                String b6 = Long.toString(i, 6);
                String b7 = Long.toString(i, 7);
                String b8 = Long.toString(i, 8);
                String b9 = Long.toString(i, 9);
                if (list2.size() != 30 && isPalindromeStr(b2)) list2.add(i);
                if (list3.size() != 30 && isPalindromeStr(b3)) list3.add(i);
                if (list4.size() != 30 && isPalindromeStr(b4)) list4.add(i);
                if (list5.size() != 30 && isPalindromeStr(b5)) list5.add(i);
                if (list6.size() != 30 && isPalindromeStr(b6)) list6.add(i);
                if (list7.size() != 30 && isPalindromeStr(b7)) list7.add(i);
                if (list8.size() != 30 && isPalindromeStr(b8)) list8.add(i);
                if (list9.size() != 30 && isPalindromeStr(b9)) list9.add(i);
                if (list2.size() == 30
                        && list3.size() == 30
                        && list4.size() == 30
                        && list5.size() == 30
                        && list6.size() == 30
                        && list7.size() == 30
                        && list8.size() == 30
                        && list9.size() == 30) break;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);
        System.out.println(list6);
        System.out.println(list7);
        System.out.println(list8);
        System.out.println(list9);
    }
}
