package _CONTEST._weekly._222;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1713. 得到子序列的最少操作次数
 * 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
 * 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
 * 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
 * 一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 * @Date: 2021/1/7
 */

public class Solution4 {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < target.length; ++i)
            h.put(target[i], i);

        ArrayList<Integer> stack = new ArrayList<>();
        for (int a : arr) {
            if (!h.containsKey(a)) continue;
            if (stack.size() == 0 || h.get(a) > stack.get(stack.size() - 1)) {
                stack.add(h.get(a));
                continue;
            }
            int left = 0, right = stack.size() - 1, mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (stack.get(mid) < h.get(a))
                    left = mid + 1;
                else
                    right = mid;
            }
            stack.set(left, h.get(a));
        }
        return target.length - stack.size();
    }
}
