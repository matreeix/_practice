package _CONTEST._biweekly._30;


import java.util.*;

/**
 * @Description: 已排序子数组和的范围总和
 * <p>
 * 给定nums由n正整数组成的数组。您计算了该数组中所有非空连续子数组的总和，然后以非降序对其进行排序，从而创建了一个新的n * (n + 1) / 2 数字数组。
 * 返回新数组中从索引left到索引right（从1开始索引）的数字总和。 由于答案可能是巨大的数字，因此以10 ^ 9 + 7为模返回。
 * @Author: Pythagodzilla
 * @Date: 2020/7/11
 */

public class Solution2 {
    //暴力法，直接构造和数组，会超出时间限制
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n * (n + 1) / 2];
        int mod = 1000000007;
        int mark = 0;
        for (int bound = 1; bound <= n; bound++) {
            for (int i = 0; i + bound <= nums.length; i++) {
                int sum = 0;
                for (int j = i; j < i + bound; j++) {
                    sum = (sum + nums[j]) % mod;
                }
                sums[mark++] = sum;
            }
        }

        Arrays.sort(sums);
        int res = 0;
        for (int index = left - 1; index < right; index++) {
            res = (res + sums[index]) % mod;
        }
        return res;
    }

    //优先队列
    static class Pair {
        long sum;
        int index;

        Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int rangeSum2(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(n, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.sum == o2.sum) {
                    return 0;
                }
                return o1.sum < o2.sum ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++)
            minHeap.offer(new Pair(nums[i], i + 1));//先将数组所有元素放入小根堆

        int res = 0, mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            Pair p = minHeap.poll();
            if (i >= left)
                res = (int) ((res + p.sum) % mod);
            //最精髓的代码，下面这段代码会将 剩下的 所有的 子数组和 依次放入小根堆中
            if (p.index < n) {
                p.sum += nums[p.index++];//1.当前元素(或者子数组和)加上后一个元素，并且指针后移一位(if判断条件保证了不会越位)
                minHeap.offer(p);        //2.由于是小根堆，保证了较小的子数组和必然会先出现并加进小根堆
            }
        }
        return res;
    }

    //前缀和，时间复杂度O(n^2 log n^2)
    public static int rangeSum3(int[] nums, int n, int left, int right) {
        long res = 0, min = Long.MAX_VALUE, mod = 1_000_000_007, sum = 0;
        List<Long> sums = new ArrayList<>(), pSum = new ArrayList<>();  // sums - all sums of subarrays, pSum - prefix sums;
        pSum.add(0L);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pSum.add(sum);
            for (int j = 0; j < pSum.size() - 1; j++)
                sums.add(sum - pSum.get(j));
        }
        Collections.sort(sums);
        while (left <= right)
            res = (res + sums.get(left++ - 1)) % mod;
        return (int) res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }
}