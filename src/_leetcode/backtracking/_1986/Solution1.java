package _leetcode.backtracking._1986;

/**
 * @Description: 1986. 完成任务的最少工作时间段
 * 你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。
 *
 * 你需要按照如下条件完成给定任务：
 *
 * 如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
 * 完成一个任务后，你可以 立马 开始一个新的任务。
 * 你可以按 任意顺序 完成任务。
 * 给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。
 *
 * 测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。
 *
 *
 * @Date: 2021/9/2
 */


//暴力回溯
public class Solution1 {
    int ans;

    public int minSessions(int[] tasks, int sessionTime) {
        ans = tasks.length + 1; // 上限
        backtrack(tasks, 0, new int[tasks.length], sessionTime, 0);
        return ans;
    }

    // idx:当前待分配tasks的索引 taskTime:分配情况 cur:当前花费的时间段总数
    public void backtrack(int[] tasks, int idx, int[] taskTime, int sessionTime, int cur) {
        if (cur >= ans) return; // 剪枝
        if (idx == tasks.length) {   // 更新结果 此时cur一定比ans小
            ans = cur;
            return;
        }
        boolean flag = false;
        for (int i = 0; i < taskTime.length; i++) {
            if (taskTime[i] == 0 && flag) break; // 第一个0即可
            if (taskTime[i] + tasks[idx] > sessionTime) continue;    // 超时
            if (taskTime[i] == 0) {
                flag = true;    // 开辟新的工作时间段
            }
            taskTime[i] += tasks[idx];
            backtrack(tasks, idx + 1, taskTime, sessionTime, flag ? cur + 1 : cur); // 开辟新时间段时 cur+1
            taskTime[i] -= tasks[idx];
        }
    }
}
