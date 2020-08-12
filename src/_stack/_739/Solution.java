package _stack._739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 等待下一个更高气温的天数（单调栈）
 * @Author: matreeix
 * @Date: 2020/3/16
 */
public class Solution {
    public static int[] dailyTemperatures(int[] T) {
        if (T.length == 1) return new int[]{0};

        int[] res = new int[T.length];
        Stack<int[]> s = new Stack<>();
        int index = 0;
        for (int i = 0; i < T.length; ++i) {
            while (!s.isEmpty() && s.peek()[0] < T[i]) {//构造单调栈
                int[] tmp = s.pop();//{T[index],index}
                res[tmp[1]] = i - tmp[1];
            }
            s.push(new int[]{T[i], index++});
        }
        return res;

    }

    public int[] dailyTemperatures2(int[] T) {
        int[] stack = new int[T.length];
        int top = -1;
        int[] ret = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));

    }

}
