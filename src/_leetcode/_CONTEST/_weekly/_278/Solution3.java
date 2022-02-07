package _leetcode._CONTEST._weekly._278;

/**
 * @Description: 2156. 查找给定哈希值的子串
 * 给定整数 p 和 m ，一个长度为 k 且下标从 0 开始的字符串 s 的哈希值按照如下函数计算：
 * hash(s, p, m) = (val(s[0]) * p0 + val(s[1]) * p1 + ... + val(s[k-1]) * pk-1) mod m.
 * 其中 val(s[i]) 表示 s[i] 在字母表中的下标，从 val('a') = 1 到 val('z') = 26 。
 * 给你一个字符串 s 和整数 power，modulo，k 和 hashValue 。请你返回 s 中 第一个 长度为 k 的 子串 sub ，满足 hash(sub, power, modulo) == hashValue 。
 * 测试数据保证一定 存在 至少一个这样的子串。
 * 子串 定义为一个字符串中连续非空字符组成的序列。
 * @Date: 2022/2/7
 */

public class Solution3 {
    public String subStrHash(String s, int p, int m, int k, int hash) {
        int len = s.length();
        String pre = s.substring(len - k, len);
        long tmpHash = 0;
        for (int i = 0; i < pre.length(); i++) {
            int cur = pre.charAt(i) - 'a' + 1;
            tmpHash += ((long) (cur % m) * qmi(p, i, m)) % m;
        }
        tmpHash %= m;
        String res = "";
        if (tmpHash == hash) {
            res = pre;
        }
        for (int i = len - k - 1; i >= 0; i--) {
            int a = s.charAt(i) - 'a' + 1;
            int b = s.charAt(i + k) - 'a' + 1;
            tmpHash = (a % m + (tmpHash * (p % m)) % m - ((long) (b % m) * qmi(p, k, m)) % m + 2L * m) % m;
            if (tmpHash == hash) {
                res = s.substring(i, i + k);
            }
        }
        return res;
    }

    public long qmi(int p, int k, int m) {
        long res = 1 % m, t = p;
        while (k > 0) {
            if ((k & 1) == 1) res = res * t % m;
            t = t * t % m;
            k >>= 1;
        }
        return res;
    }

    public String subStrHash2(String s, int p, int m, int k, int hashValue) {
        long cur = 0, pk = 1;
        int res = 0, n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            cur = (cur * p + s.charAt(i) - 'a' + 1) % m;
            if (i + k >= n)
                pk = pk * p % m;
            else
                cur = (cur - (s.charAt(i + k) - 'a' + 1) * pk % m + m) % m;
            if (cur == hashValue)
                res = i;
        }
        return s.substring(res, res + k);
    }
}
