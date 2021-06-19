package _leetcode._CONTEST._weekly._223;

/**
 * @Description: 5639. 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 * @Date: 2021/1/10
 */

public class Solution4 {
    int result = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        //Arrays.sort(jobs);
        backtracking(jobs, 0, new int[k], 0);
        return result;
    }

    private void backtracking(int[] jobs, int index, int[] workers, int max) {

        if (index == jobs.length) {
            result = Math.min(result, max);
            return;
        }

        if (max > result) {
            return;
        }

        for (int i = 0; i < workers.length; i++) {
            workers[i] += jobs[index];
            backtracking(jobs, index+1, workers, Math.max(workers[i], max));
            workers[i] -= jobs[index];

            if (workers[i] == 0) {
                break;
            }
        }

    }
}























