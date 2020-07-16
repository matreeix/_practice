package backtracking._1140;

/**
 * @Description: 石子游戏II
 * <p>
 * 亚历克斯和李继续他们的石子游戏。许多堆石子排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 * 在每个玩家的回合中，该玩家可以拿走剩下的前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * 游戏一直持续到所有石子都被拿走。
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 * @Author: Pythagodzilla
 * @Date: 2020/7/16
 */

public class Solution {
    private int[] sums;//the sum from piles[i] to the end
    private int[][] hash;

    public int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0) return 0;
        int n = piles.length;
        sums = new int[n];
        sums[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sums[i] = sums[i + 1] + piles[i]; //the sum from piles[i] to the end
        }

        hash = new int[n][n];
        return helper(piles, 0, 1);
    }

    private int helper(int[] a, int i, int M) {
        if (i == a.length) return 0;
        if (2 * M >= a.length - i) {
            return sums[i];
        }
        if (hash[i][M] != 0) return hash[i][M];
        int min = Integer.MAX_VALUE;//the min value the next player can get
        for (int x = 1; x <= 2 * M; x++) {
            min = Math.min(min, helper(a, i + x, Math.max(M, x)));
        }
        hash[i][M] = sums[i] - min;  //max stones = all the left stones - the min stones next player can get
        return hash[i][M];
    }

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        Solution s = new Solution();
        System.out.println(s.stoneGameII(piles));
    }
}
