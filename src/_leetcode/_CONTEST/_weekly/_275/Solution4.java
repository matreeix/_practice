package _leetcode._CONTEST._weekly._275;

import java.util.Arrays;

/**
 * @Description: 5979. 全部开花的最早一天
 * 你有 n 枚花的种子。每枚种子必须先种下，才能开始生长、开花。播种需要时间，种子的生长也是如此。给你两个下标从 0 开始的整数数组 plantTime 和 growTime ，每个数组的长度都是 n ：
 * plantTime[i] 是 播种 第 i 枚种子所需的 完整天数 。每天，你只能为播种某一枚种子而劳作。无须 连续几天都在种同一枚种子，但是种子播种必须在你工作的天数达到 plantTime[i] 之后才算完成。
 * growTime[i] 是第 i 枚种子完全种下后生长所需的 完整天数 。在它生长的最后一天 之后 ，将会开花并且永远 绽放 。
 * 从第 0 开始，你可以按 任意 顺序播种种子。
 * 返回所有种子都开花的 最早 一天是第几天。
 * 提示：
 * n == plantTime.length == growTime.length
 * 1 <= n <= 10^5
 * 1 <= plantTime[i], growTime[i] <= 10^4
 * @Date: 2022/1/9
 */

public class Solution4 {
    //贪心证明：https://leetcode-cn.com/problems/earliest-possible-day-of-full-bloom/solution/tan-xin-yan-ge-zheng-ming-quan-bu-kai-hu-k8k1/
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int res = 0;
        int n = plantTime.length;
        int[] growIdx = new int[n];
        for (int i = 0; i < n; i++) growIdx[i] = growTime[i] * 100001 + i;
        Arrays.sort(growIdx);// 优先选择种植开花时间最长的
        int curP = 0;
        for (int i = n - 1; i >= 0; i--) {
            curP += plantTime[growIdx[i] % 100001];
            res = Math.max(res, curP +  growIdx[i] / 100001);
        }
        return res;
    }
}
