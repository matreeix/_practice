package _math._264;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Description: 丑数II
 * <p>
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * @Author: matreeix
 * @Date: 2020/7/3
 */

public class Solution {

    public static Ugly u = new Ugly();

    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}

//堆和哈希表
class Ugly {
    public int[] nums = new int[1690];//先预计算1690个数字

    Ugly() {
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.add(1L);

        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < 1690; ++i) {
            currUgly = heap.poll();
            nums[i] = (int) currUgly;
            for (int j : primes) {
                newUgly = currUgly * j;//弹出最小值分别乘以2、3、5再放入堆中
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
    }
}

//dp（妙啊！）,三指针法,核心原理是没一个丑数都是由前面某个丑数乘以2或者3或者5得到的
class Ugly2 {
    public int[] nums = new int[1690];

    Ugly2() {
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < 1690; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;
            if (ugly == nums[i2] * 2) ++i2;
            if (ugly == nums[i3] * 3) ++i3;
            if (ugly == nums[i5] * 5) ++i5;
        }
    }
}