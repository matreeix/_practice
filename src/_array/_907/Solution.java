package _array._907;

import java.util.Stack;

/**
 * @Description: 求出所有连续子数组中的最小值之和
 * @Author: 67ng
 * @Date: 2020/3/15
 */
public class Solution {

    //优化后
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

    //left[i], the length of strict bigger numbers on the left of A[i],
    //right[i], the length of bigger numbers on the right of A[i].
    //f(i) is the number of subarrays,in which A[i] is the minimum.
    //f(i) = (left[i] + 1) * (right[i] + 1)
    //So,res = sum(A[i] * f(i))
    public int sumSubarrayMins2(int[] A) {
        int res = 0, n = A.length, mod = (int) 1e9 + 7;
        int[] left = new int[n], right = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i])
                count += s1.pop()[1];
            s1.push(new int[]{A[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i])
                count += s2.pop()[1];
            s2.push(new int[]{A[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * left[i] * right[i]) % mod;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2e2);
        int[] arr = {3, 1, 2, 4};
        System.out.println((new Solution()).sumSubarrayMins(arr));
    }
}
