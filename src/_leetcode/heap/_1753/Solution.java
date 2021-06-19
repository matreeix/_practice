package _leetcode.heap._1753;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 1753. 移除石子的最大得分
 * 你正在玩一个单人游戏，面前放置着大小分别为 a​​​​​​、b 和 c​​​​​​ 的 三堆 石子。
 * 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。
 * 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。
 * @Date: 2021/2/19
 */

public class Solution {
    //优先队列，杀鸡用牛刀性能不好
    public static int maximumScore(int a, int b, int c) {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.add(a);
        q.add(b);
        q.add(c);
        int res = 0;
        while (true) {
            int aa = q.poll();
            int bb = q.poll();
            if (aa > 0 && bb > 0) {
                q.add(aa - 1);
                q.add(bb - 1);
                res++;
            } else {
                return res;
            }
        }
    }

    //数学法
    public static int maximumScore2(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        int mid = a + b + c - min - max;
        if (min + mid <= max)
            return min + mid;
        else
            return (a + b + c) / 2;
//        if (a + b < c) return a + b;
//        if (a + c < b) return a + c;
//        if (c + b < a) return b + c;
//        return (a + b + c) / 2;

        //精简写法
//        return Math.min((a + b + c) / 2, a + b + c - Math.max(Math.max(a, b), c));
    }


    public static void main(String[] args) {
        System.out.println(maximumScore2(2, 4, 6));
        System.out.println(maximumScore2(4, 4, 6));
        System.out.println(maximumScore2(1, 8, 8));
    }
}
