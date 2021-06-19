package _leetcode._CONTEST._weekly._223;

import java.util.HashMap;

/**
 * @Description: 1722. 执行交换操作后的最小汉明距离
 * 给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 * 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
 * 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 * 提示：
 * n == source.length == target.length
 * 1 <= n <= 10^5
 * 1 <= source[i], target[i] <= 10^5
 * 0 <= allowedSwaps.length <= 10^5
 * allowedSwaps[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * @Date: 2021/1/14
 */

public class Solution3 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length, p = 0;
        int[] rd = new int[n];
        for (int i = 1; i < n; ++i) rd[i] = i;
        for (int[] as : allowedSwaps) {
            int a = find(rd, as[0]), b = find(rd, as[1]);
            rd[b] = a;
        }
        HashMap<Integer, Integer>[] hs = new HashMap[n];
        for (int i = 0; i < n; ++i) hs[i] = new HashMap();
        for (int i = 0; i < n; ++i) {
            int t = find(rd, i);
            hs[t].put(source[i], hs[t].getOrDefault(source[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int t = find(rd, i);
            int c = hs[t].getOrDefault(target[i], 0);
            if (c == 0) ++res;
            else {
                --c;
                hs[t].put(target[i], c);
            }
        }
        return res;
    }

    private int find(int[] rd, int idx) {
        while (idx != rd[idx]) {
            rd[idx] = rd[rd[idx]];
            idx = rd[idx];
        }
        return idx;
    }
}
