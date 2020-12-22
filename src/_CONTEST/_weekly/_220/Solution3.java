package _CONTEST._weekly._220;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 1696. 跳跃游戏 VI
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * 请你返回你能得到的 最大得分 。
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * -10^4 <= nums[i] <= 10^4
 * @Author: matreeix
 * @Date: 2020/12/21
 */

public class Solution3 {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        queue.offer(new int[]{nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            while (i - queue.peek()[1] > k){
                queue.poll();
            }
            res = queue.peek()[0] + nums[i];
            queue.offer(new int[]{res, i});
        }
        return res;


    }


}

