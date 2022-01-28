package _leetcode.IQ_test._2029;

/**
 * @Description: 2029. 石子游戏 IX
 * Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，其中 stones[i] 是第 i 个石子的价值。
 * Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。
 * 如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
 * 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
 * 假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。
 * @Date: 2021/11/11
 */

public class Solution {
    /**
     * 1.不考虑0的情况时所取的序列有两种情况112121212....和221212121....0可以插入在任意非首位的位置
     * 2.当s[0]为偶数时，若1或2个数为零，要么石头能取完，要么111Alice会拿到3的倍数也会输；
     * 3.若均不为零时，Alice取少的一个则必赢，相等时取任一个均能赢
     * 4.当s[0]为奇数时，次序能颠倒，故当1和2个数相差大于2时，取多的一个则在颠倒次序后alice必赢，否则就输
     */
    public boolean stoneGameIX(int[] stones) {
        int[] c = new int[3];
        for (int stone : stones) c[stone % 3]++;
        if (c[0] % 2 == 0) return c[1] > 0 && c[2] > 0;
        return c[1] - 2 > c[2] || c[2] - 2 > c[1];
    }
}
