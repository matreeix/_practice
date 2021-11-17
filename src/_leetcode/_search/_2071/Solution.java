package _leetcode._search._2071;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description: 2071. 你可以安排的最多任务数目
 * 给你 n 个任务和 m 个工人。每个任务需要一定的力量值才能完成，需要的力量值保存在下标从 0 开始的整数数组 tasks 中，
 * 第 i 个任务需要 tasks[i] 的力量才能完成。每个工人的力量值保存在下标从 0 开始的整数数组 workers 中，第 j 个工人的力量值为 workers[j] 。
 * 每个工人只能完成 一个 任务，且力量值需要 大于等于 该任务的力量要求值（即 workers[j] >= tasks[i] ）。
 * 除此以外，你还有 pills 个神奇药丸，可以给 一个工人的力量值 增加 strength 。你可以决定给哪些工人使用药丸，但每个工人 最多 只能使用 一片 药丸。
 * 给你下标从 0 开始的整数数组tasks 和 workers 以及两个整数 pills 和 strength ，请你返回 最多 有多少个任务可以被完成。
 * @Date: 2021/11/16
 */

public class Solution {
    /**
     * 考虑值最大的那个任务，此时会出现两种情况：
     * 1.如果有工人的值大于等于该任务的值，那么我们一定不需要使用药丸，并且一定让值最大的工人完成该任务。
     * 2.如果所有工人的值都小于该任务的值，那么我们必须使用药丸让一名工人完成任务，并且一定让值最小的工人完成该任务。
     */
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int tLen = tasks.length, wLen = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int ans = 0, left = 0, right = Math.min(wLen, tLen);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, pills, wLen, workers, tasks, strength)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int mid, int pills, int wLen, int[] workers, int[] tasks, int strength) {
        Deque<Integer> q = new ArrayDeque<>();
        int wIdx = wLen - 1;
        // 恰好可以完成mid个任务，从大到小枚举每一个任务
        for (int i = mid - 1; i >= 0; --i) {
            while (wIdx >= wLen - mid && workers[wIdx] + strength >= tasks[i]) {
                q.addFirst(workers[wIdx]);
                --wIdx;
            }
            if (q.isEmpty()) {
                return false;
            } else if (q.getLast() >= tasks[i]) {// 如果双端队列中最大的元素大于等于 tasks[i]
                q.pollLast();
            } else {
                if (pills == 0) return false;
                --pills;
                q.pollFirst();
            }
        }
        return true;
    }
}
