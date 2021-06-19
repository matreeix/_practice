package _leetcode._CONTEST._weekly._217;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Description: 1675. 数组的最小偏移量
 * 给你一个由 n 个正整数组成的数组 nums 。
 * <p>
 * 你可以对数组的任意元素执行任意次数的两类操作：
 * <p>
 * 如果元素是 偶数 ，除以 2
 * 例如，如果数组是 [1,2,3,4] ，那么你可以对最后一个元素执行此操作，使其变成 [1,2,3,2]
 * 如果元素是 奇数 ，乘上 2
 * 例如，如果数组是 [1,2,3,4] ，那么你可以对第一个元素执行此操作，使其变成 [2,2,3,4]
 * 数组的 偏移量 是数组中任意两个元素之间的 最大差值 。
 * <p>
 * 返回数组在执行某些操作之后可以拥有的 最小偏移量 。
 * @Author: matreeix
 * @Date: 2020/12/1
 */

public class Solution4 {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2);
        }
        int res = set.last() - set.first();
        while (res > 0 && set.last() % 2 == 0) {
            int max = set.last();
            set.remove(max);
            set.add(max / 2);
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }

    public int minimumDeviation2(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = A.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int a : A) {
            if (a % 2 == 1) a *= 2;
            pq.add(-a);
            mi = Math.min(mi, a);
        }
        while (true) {
            int a = -pq.poll();
            res = Math.min(res, a - mi);
            if (a % 2 == 1) break;
            mi = Math.min(mi, a / 2);
            pq.add(-a / 2);
        }
        return res;
    }
}
