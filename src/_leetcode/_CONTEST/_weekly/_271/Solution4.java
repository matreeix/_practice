package _leetcode._CONTEST._weekly._271;

/**
 * @Description: 5955. 摘水果
 * 在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，
 * 其中 fruits[i] = [positioni, amounti] 表示共有 amounti 个水果放置在 positioni 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
 * 另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。
 * 在 x 轴上每移动 一个单位 ，就记作 一步 。你总共可以走 最多 k 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
 * 返回你可以摘到水果的 最大总数 。
 * 提示：
 * 1 <= fruits.length <= 10^5
 * fruits[i].length == 2
 * 0 <= startPos, positioni <= 2 * 10^5
 * 对于任意 i > 0 ，positioni-1 < positioni 均成立（下标从 0 开始计数）
 * 1 <= amounti <= 10^4
 * 0 <= k <= 2 * 10^5
 * @Date: 2021/12/12
 */

public class Solution4 {
    /**
     * 二分搜索我们可以到达的最左边的位置，即pos - k。
     * 然后，我们使用滑动窗口方法，跟踪l和r迭代器之间的总和。
     * 这里的一个问题是弄清楚窗口大小。如果正确的迭代器指向起始位置之后，我们可以：
     * 1.向右再向左走（(r - start) * 2 步），然后向左走（start - l步）
     * 2.或者，向左再向右走（(start - l) * 2 步），然后向右走（r - start 步）。
     * 这两个选项中最小的一个不应超过k步骤。因此，我们移动左迭代器，直到我们的窗口大小适合k步长。
     * */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int l = 0, sum = 0, res = 0;
        while (l < fruits.length && fruits[l][0] < startPos - k)// 得到左边界
            ++l;
        for (int r = l; r < fruits.length && fruits[r][0] <= startPos + k; ++r) {
            sum += fruits[r][1];
            while (Math.min(startPos - 2 * fruits[l][0] + fruits[r][0], 2 * fruits[r][0] - fruits[l][0] - startPos) > k)//当前的总步数越界了，增大左边界
                sum -= fruits[l++][1];//缩减窗口到最大值
            res = Math.max(res, sum);
        }
        return res;
    }
}
