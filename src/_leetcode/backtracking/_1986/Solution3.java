package _leetcode.backtracking._1986;

import java.util.Random;

/**
 * @Description: 模拟退火算法
 * @Date: 2021/9/2
 */

public class Solution3 {
    private double INTERVAL = 0.95;// 退火速率

    public int ck(int[] tasks, int t) {
        int cnt = 0, now = 0, c[] = new int[15];
        for (int task : tasks) {
            if (c[task] > 0) {
                --c[task];
            } else {
                if (now + task <= t) {
                    now += task;
                } else {// 开辟新的时间段
                    ++c[t - now];// 剩余t-now的时间可用
                    now = task;
                    ++cnt;
                }
            }
        }
        return cnt + ((now > 0) ? 1 : 0);
    }

    public int SA(int[] tasks, int t) {
        shuffle(tasks);
        int n = tasks.length, ans = ck(tasks, t), low = (accumulate(0, tasks.length - 1, 0, tasks) + t - 1) / t;
        Random r = new Random();
        for (double T = 1e5; T > 1e-5 && ans > low; T *= INTERVAL) {
            int pre = ck(tasks, t);
            swap(r.nextInt(n), r.nextInt(n), tasks);
            int cur = ck(tasks, t);
            int dif = cur - pre;
            if (dif < 0) {//dif < 0， 新状态更优
                ans = cur;
            } else {//dif >= 0 老状态更优，根据概率确定是否保留新状态
                if (r.nextInt(Integer.MAX_VALUE) > Math.exp((dif) / T) * Integer.MAX_VALUE) {
                    swap(r.nextInt(n), r.nextInt(n), tasks);// 还原状态
                }
            }
        }
        return ans;
    }

    //洗牌算法
    public void shuffle(int[] nums) {
        Random r = new Random();
        for (int i = nums.length; i > 1; i--)
            swap(i - 1, r.nextInt(i), nums);
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //计算[start,end]数组和
    public int accumulate(int start, int end, int ini, int[] nums) {
        int res = ini;
        for (int i = start; i <= end; i++) {
            res += nums[i];
        }
        return res;
    }

    public int minSessions(int[] tasks, int sessionTime) {
        int ans = Integer.MAX_VALUE, low = (accumulate(0, tasks.length - 1, 0, tasks) + sessionTime - 1) / sessionTime;//需要的时间段的下限
        for (int i = 0; i < 10 && ans > low; i++)
            ans = Math.min(ans, SA(tasks, sessionTime));
        return ans;
    }
}
