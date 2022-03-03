package _leetcode._CONTEST._biweekly._68;

import java.math.BigInteger;

/**
 * @Description: 5949. 一个区间内所有数乘积的缩写
 * 给你两个正整数 left 和 right ，满足 left <= right 。请你计算 闭区间 [left, right] 中所有整数的 乘积 。
 * 由于乘积可能非常大，你需要将它按照以下步骤 缩写 ：
 * 统计乘积中 后缀 0 的数目，将这个数目记为 C 。
 * 比方说，1000 中有 3 个后缀 0 ，546 中没有后缀 0 。
 * 将乘积中剩余数字记为 d 。如果 d > 10 ，那么将乘积表示为 <pre>...<suf> 的形式，其中 <pre> 表示乘积最 开始 的 5 个数位，<suf> 表示删除后缀 0 之后 结尾的 5 个数位。如果 d <= 10 ，我们不对它做修改。
 * 比方说，我们将 1234567654321 表示为 12345...54321 ，但是 1234567 仍然表示为 1234567 。
 * 最后，将乘积表示为 字符串 "<pre>...<suf>eC" 。
 * 比方说，12345678987600000 被表示为 "12345...89876e5" 。
 * 请你返回一个字符串，表示 闭区间 [left, right] 中所有整数 乘积 的 缩写 。
 * 1 <= left <= right <= 10^6
 * @Date: 2021/12/27
 */

public class Solution4 {
    public String abbreviateProduct(int left, int right) {
        long two = 0, five = 0, min = 0, flag = 0, last = 1;
        for (int i = left, j; (j = i) <= right; i++) {
            for (; j % 2 == 0; j /= 2, two++) ;
            for (; j % 5 == 0; j /= 5, five++) ;
        }
        two = five = min = Math.min(two, five);
        double first = 1;
        for (int i = left; i <= right; i++) {
            for (last *= i; last % 2 == 0 && two-- > 0; last /= 2)
                for (; last % 5 == 0 && five-- > 0; last /= 5)
                    if (last > 10000000000L) {
                        flag = 1;
                        last %= 10000000000L;
                    }
            for (first *= i; first > 100000; first /= 10) ;
        }
        return (flag == 0 ? last : (int) first + "..." + String.format("%05d", last % 100000)) + "e" + min;
    }

    public String abbreviateProduct2(int left, int right) {
        long suff = 1, zero = 0, max_suff = 1_000_000_000_000L;
        double pref = 1.0;
        for (int i = left; i <= right; ++i) {
            pref *= i;
            while (pref >= 100000) pref /= 10;
            suff *= i;
            while (suff % 10 == 0) {
                suff /= 10;
                ++zero;
            }
            suff %= max_suff;
        }
        String s = Long.toString(suff);
        return (s.length() <= 10 ? s : Long.toString((int) pref) + "..." + s.substring(s.length() - 5)) + "e" + zero;
    }

    public static void main(String[] args) {
        int start = 3940, end = 836328;
        BigInteger a = new BigInteger("" + start);
        for (int i = start + 1; i <= end; i++) {
            a = a.multiply(new BigInteger(i + ""));
        }
        double pref = 1.0;
        for (int i = start; i <= end; ++i) {
            pref *= i;
            while (pref >= 1000000) pref /= 10;
        }

        System.out.println("pref:" + pref);
        System.out.println("actual:" + a.toString().substring(0, 5));
    }
}
