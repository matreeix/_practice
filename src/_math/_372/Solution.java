package _math._372;

import java.util.LinkedList;

/**
 * @Description: 超级次方
 * <p>
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * @Author: Pythagodzilla
 * @Date: 2020/6/19
 */

public class Solution {
    int mu = 1337;

    public int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int bb : b) {
            list.add(bb);
        }
        return superP(a, list);

    }

    public int superP(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        int last = list.peekLast();
        list.pollLast();
        int res1 = quickMul(a, last);
        int res2 = quickMul(superP(a, list), 10);
        return res1 * res2 % mu;
    }

    public int quickMul(int a, int n) {

        if (n == 0) {
            return 1;
        }
        a %= 1337;
        int ans = 1;
        int x = a;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x % mu;
            }
            x = x * x % mu;
            n /= 2;
        }
        return ans % mu;
    }

    //性能最优解法
    public int superPow2(int a, int[] b) {
        if (a % 1337 == 0)
            return 0;
        int p = 0;
        for (int i : b)
            p = (p * 10 + i) % 1140;//what the fuck?
        //if (p == 0) p += 1440;
        return power(a, p, 1337);
    }

    public int power(int a, int n, int mod) {
        a %= mod;
        int ret = 1;
        while (n != 0) {
            if ((n & 1) != 0)
                ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int a = 2;
        int[] b = {1, 0};
//        int[] b = {1, 0, 2, 4, 6};
        Solution s = new Solution();
        System.out.println(s.superPow(a, b));
    }
}
