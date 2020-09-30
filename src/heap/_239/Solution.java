package heap._239;

import java.util.*;

/**
 * @Description: 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * @Author: matreeix
 * @Date: 2020/9/29
 */

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= k - 1) {
                queue.add(nums[i]);
            } else {
                res[idx] = queue.peek();
                queue.remove(nums[idx++]);
                queue.add(nums[i]);
            }
        }
        res[res.length - 1] = queue.peek();
        return res;
    }

    public int[] maxSlidingWindow2(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

}

class Monoqueue {
    Deque<Integer> q = new ArrayDeque<>();

    public void push(Integer n) {

        while (!q.isEmpty() && q.peekLast().compareTo(n) < 0) q.pollLast();
        q.offerLast(n);
    }

    public Integer front() {
        return q.peekFirst();
    }

    public void pop(Integer n){
        if (n.equals(q.peekFirst())) q.pollFirst();
    }

}
