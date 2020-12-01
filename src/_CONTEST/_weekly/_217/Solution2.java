package _CONTEST._weekly._217;

import java.util.Stack;

/**
 * @Description: 1673. 找出最具竞争力的子序列
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，
 * 那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，
 * 在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 * @Author: matreeix
 * @Date: 2020/11/30
 */

public class Solution2 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] < stack.peek() && k + 1 - stack.size() < len - i) stack.pop();
            if (stack.size() < k + 1) stack.add(nums[i]);//维护单调栈大小为k
        }

        int[] ret = new int[k];
        while (k > 0) ret[--k] = stack.pop();
        return ret;
    }
}
