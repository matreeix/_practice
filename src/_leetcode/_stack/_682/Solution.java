package _leetcode._stack._682;

import java.util.Stack;

/**
 * @Description: 682. 棒球比赛
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * 1.整数 x - 表示本回合新获得分数 x
 * 2."+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * 3."D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 4."C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 * @Date: 2021/3/29
 */

public class Solution {

    //栈
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int a = stack.pop();
                    int b = stack.peek();
                    stack.push(a);
                    stack.push(a + b);
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(op));
                    break;
            }
        }
        int res = 0;
        while (stack.size() > 0)
            res += stack.pop();
        return res;
    }

    //数组
    public int calPoints2(String[] ops) {
        int[] arr = new int[ops.length];
        int i = 0;
        for (String s : ops) {
            switch (s) {
                case "+":
                    arr[i] = arr[i - 1] + arr[i - 2];
                    i++;
                    break;
                case "D":
                    arr[i] = 2 * arr[i - 1];
                    i++;
                    break;
                case "C":
                    arr[i - 1] = 0;
                    i--;
                    break;
                default:
                    arr[i] = Integer.parseInt(s);
                    i++;
            }
        }
        int sum = 0;
        for (int value : arr) sum += value;
        return sum;
    }

}
