package _leetcode._DP._313;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * @Date: 2021/12/31
 */

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }

    public int nthSuperUglyNumberHeap(int n, int[] primes) {
        int[] ugly = new int[n];

        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]) {
                Num nxt = pq.poll();
                pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
            }
        }

        return ugly[n - 1];
    }

    private class Num implements Comparable<Num> {
        int val;
        int idx;
        int p;

        public Num(int val, int idx, int p) {
            this.val = val;
            this.idx = idx;
            this.p = p;
        }

        @Override
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }
}
