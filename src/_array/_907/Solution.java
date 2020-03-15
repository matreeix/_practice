package _array._907;

import java.util.Stack;

/**
 * @Description: 求出所有连续子数组中的最小值之和
 * @Author: 67ng
 * @Date: 2020/3/15
 */
public class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length, res = 0, mod = (int) 1e9 + 7, j, k;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > (i == n ? 0 : A[i])) {//单调栈
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res = (res + A[j] * (i - j) * (j - k)) % mod;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2e2);
    }
}
