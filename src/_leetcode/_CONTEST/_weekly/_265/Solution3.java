package _leetcode._CONTEST._weekly._265;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 2059. 转化数字的最小运算数
 * 给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。
 * 整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算：
 * 如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值：
 * x + nums[i]
 * x - nums[i]
 * x ^ nums[i]（按位异或 XOR）
 * 注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他运算。
 * 返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。
 * @Date: 2021/11/8
 */

public class Solution3 {
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] visited = new boolean[1001];
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int[] arr = new int[q.size()];
            for (int i = 0; i < arr.length; i++)
                arr[i] = q.poll();
            for (int cur : arr)
                for (int num : nums)
                    for (int next : new int[]{cur + num, cur - num, cur ^ num}) {
                        if (next == goal) return step + 1;
                        if (0 <= next && next <= 1000 && !visited[next]) {
                            q.add(next);
                            visited[next] = true;
                        }
                    }
            step++;
        }
        return -1;
    }
}
