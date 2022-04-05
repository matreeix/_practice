package _leetcode._CONTEST._weekly._287;

/**
 * @Description: 5219. 每个小孩最多能分到多少糖果
 * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
 * 返回每个小孩可以拿走的 最大糖果数目 。
 * 提示：
 * 1 <= candies.length <= 10^5
 * 1 <= candies[i] <= 10^7
 * 1 <= k <= 10^12
 * @Date: 2022/4/4
 */

public class Solution3 {
    public static int maximumCandies(int[] candies, long k) {
        int max = 0;
        long sum = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
            sum += candy;
        }
        if (sum < k) return 0;
        int l = 1, r = max;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(mid, k, candies) == -1) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private static int check(int target, long k, int[] candies) {
        long cnt = 0;
        for (int candy : candies) {
            cnt += candy / target;
            if (cnt >= k) return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] c = {4, 7, 5};
        int[] c1 = {1, 2, 3, 4, 10};
        int[] c2 = {5, 6, 4, 10, 10, 1, 1, 2, 2, 2};
        System.out.println(maximumCandies(c, 4));//3
        System.out.println(maximumCandies(c1, 5));//3
        System.out.println(maximumCandies(c2, 9));//3
    }
}
