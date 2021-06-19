package _leetcode._stack._636;

import java.util.*;

/**
 * @Description: 函数的运行时间
 * @Author: matreeix
 * @Date: 2020/5/30
 */
public class Solution {
    //官方答案
    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);//prev是起始时间
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }

    class Task {
        int id = 0;
        int time = 0;
        boolean isStart = true;

        Task(String[] split) {
            this.id = Integer.valueOf(split[0]);
            this.time = Integer.valueOf(split[2]);
            this.isStart = split[1].equals("start");
        }
    }

    //新建任务类，易于理解
    public int[] exclusiveTime2(int n, List<String> logs) {
        Stack<Task> stack = new Stack<>();
        int[] ans = new int[n];
        for (String log : logs) {
            Task task = new Task(log.split(":"));
            if (task.isStart) {
                stack.push(task);
            } else {
                Task last = stack.pop();
                int duration = task.time - last.time + 1;
                ans[task.id] += duration;
                // 栈若不空，说明之前还有任务没有执行完成，那个任务的执行时间需要减去当前任务的执行时间
                if (!stack.isEmpty()) {
                    ans[stack.peek().id] -= duration;
                }
            }
        }
        return ans;
    }

    public int[] exclusiveTime3(int n, List<String> logs) {
        Stack<String[]> stack = new Stack<>();
        int[] ans = new int[n];
        for (String log : logs) {
            String[] task = log.split(":");
            if ("start".equals(task[1])) {
                stack.push(task);
            } else {
                String[] last = stack.pop();
                int duration = Integer.valueOf(task[2]) - Integer.valueOf(last[2]) + 1;
                ans[Integer.valueOf(task[0])] += duration;
                // 栈若不空，说明之前还有任务没有执行完成，那个任务的执行时间需要减去当前任务的执行时间
                if (!stack.isEmpty()) {
                    ans[Integer.valueOf(stack.peek()[0])] -= duration;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
//        logs.add("0:start:0");
//        logs.add("1:start:2");
//        logs.add("1:end:5");
//        logs.add("0:end:6");
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("1:start:6");
        logs.add("1:end:6");
        logs.add("0:end:7");
//        List<String> logs = new ArrayList<>();
//        logs.add("0:start:0");
//        logs.add("0:start:2");
//        logs.add("0:end:5");
//        logs.add("0:start:6");
//        logs.add("0:end:6");
//        logs.add("0:end:7");
        System.out.println(Arrays.toString(exclusiveTime(n, logs)));
    }

}
