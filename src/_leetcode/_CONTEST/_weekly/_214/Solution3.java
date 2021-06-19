package _leetcode._CONTEST._weekly._214;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 5563. 销售价值减少的颜色球
 * 你有一些球的库存 inventory ，里面包含着不同颜色的球。一个顾客想要 任意颜色 总数为 orders 的球。
 * 这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的 同色球 的数目。比方说还剩下 6 个黄球，
 * 那么顾客买第一个黄球的时候该黄球的价值为 6 。这笔交易以后，只剩下 5 个黄球了，所以下一个黄球的价值为 5 （也就是球的价值随着顾客购买同色球是递减的）
 * 给你整数数组 inventory ，其中 inventory[i] 表示第 i 种颜色球一开始的数目。同时给你整数 orders ，表示顾客总共想买的球数目。你可以按照 任意顺序 卖球。
 * 请你返回卖了 orders 个球以后 最大 总价值之和。由于答案可能会很大，请你返回答案对 10^9 + 7 取余数 的结果。
 * <p>
 * 提示：
 * 1 <= inventory.length <= 10^5
 * 1 <= inventory[i] <= 10^9
 * 1 <= orders <= min(sum(inventory[i]), 10^9)
 * @Author: matreeix
 * @Date: 2020/11/8
 */

public class Solution3 {
    //优先队列，O(orders⋅logn)，TLE
    public static int maxProfit(int[] inventory, int orders) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int ball : inventory)
            q.add(ball);
        int res = 0;
        while (orders > 0) {
            int tmp = q.poll();
            res = (res + tmp) % 1000000007;
            q.add(tmp - 1);
            orders--;
        }
        return res;
    }

    //二分查找
    public static int maxProfit2(int[] inventory, int orders) {
        int mod = (int) (1e9 + 7);
        int l = 0, r = getMax(inventory);
        while (l < r) {//找到得到结果时的最大球数值
            int mid = l + (r - l) / 2;
            if (provideOrders(inventory, mid) <= orders) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long res = 0;
        for (int num : inventory) {
            if (num >= l) {
                orders -= (num - l + 1);//消耗的次数
                res = (res + ((long) (l + num) * (num - l + 1) / 2) % mod) % mod;
            }
        }
        res = (res + (long) orders * (l - 1) % mod) % mod;//需要加上在最大值时减去部分的数，即 还剩余的次数
        return (int) res;
    }

    private static long provideOrders(int[] inventory, int m) {
        long orders = 0;
        for (int num : inventory) {
            orders += Math.max(num - m + 1, 0);
        }
        return orders;
    }

    private static int getMax(int[] inventory) {
        int max = 0;
        for (int num : inventory)
            max = Math.max(max, num);
        return max;
    }

    public static void main(String[] args) {
        int[] inventory = {1000000000};
        int orders = 1000000000;
        System.out.println(maxProfit2(inventory, orders));
    }
}
