package _greedy._517;

/**
 * @Description: 517. 超级洗衣机
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。
 * 如果不能使每台洗衣机中衣物的数量相等，则返回 -1
 * @Author: matreeix
 * @Date: 2020/7/31
 */

public class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0, n = machines.length;
        for (int m : machines)
            total += m;
        if (total % n > 0) return -1;
        int target = total / n, res = 0, toRight = 0;//toRight表示要放到右边洗衣机的衣服数量
        for (int m : machines) {
            toRight = m + toRight - target;
            res = Math.max(res, Math.max(Math.abs(toRight), m - target));
        }
        return res;
    }

}