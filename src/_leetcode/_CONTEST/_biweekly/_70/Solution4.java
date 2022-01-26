package _leetcode._CONTEST._biweekly._70;

/**
 * @Description: 2147. 分隔长廊的方案数
 * 在一个图书馆的长廊里，有一些座位和装饰植物排成一列。给你一个下标从 0 开始，长度为 n 的字符串 corridor ，它包含字母 'S' 和 'P' ，其中每个 'S' 表示一个座位，每个 'P' 表示一株植物。
 * 在下标 0 的左边和下标 n - 1 的右边 已经 分别各放了一个屏风。你还需要额外放置一些屏风。每一个位置 i - 1 和 i 之间（1 <= i <= n - 1），至多能放一个屏风。
 * 请你将走廊用屏风划分为若干段，且每一段内都 恰好有两个座位 ，而每一段内植物的数目没有要求。可能有多种划分方案，如果两个方案中有任何一个屏风的位置不同，那么它们被视为 不同 方案。
 * 请你返回划分走廊的方案数。由于答案可能很大，请你返回它对 109 + 7 取余 的结果。如果没有任何方案，请返回 0 。
 * 提示：
 * n == corridor.length
 * 1 <= n <= 10^5
 * corridor[i] 要么是 'S' ，要么是 'P' 。
 * @Date: 2022/1/26
 */

public class Solution4 {
    public int numberOfWays(String corridor) {
        if (corridor.length() < 2) return 0;
        int cntS = 0;
        for (char c : corridor.toCharArray())
            if (c == 'S')
                cntS++;
        if (cntS % 2 != 0 || cntS == 0) return 0;
        long res = 1;
        int tmp = 0;
        cntS = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'P') {
                if (cntS % 2 == 0 && cntS > 0) {
                    tmp++;
                }
            } else {
                res = (res * (tmp + 1)) % 1000000007;
                tmp = 0;
                cntS++;
            }
        }

        return (int) res;
    }

    public int numberOfWays2(String s) {
        long res = 1, j = 0, k = 0, mod = (long) 1e9 + 7;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'S') {
                if (++k > 2 && k % 2 == 1)
                    res = res * (i - j) % mod;
                j = i;
            }
        }
        return k % 2 == 0 && k > 0 ? (int) res : 0;
    }
}
