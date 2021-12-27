package _leetcode._CONTEST._weekly._273;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 5966. 还原原数组
 * Alice 有一个下标从 0 开始的数组 arr ，由 n 个正整数组成。她会选择一个任意的 正整数 k 并按下述方式创建两个下标从 0 开始的新整数数组 lower 和 higher ：
 * 对每个满足 0 <= i < n 的下标 i ，lower[i] = arr[i] - k
 * 对每个满足 0 <= i < n 的下标 i ，higher[i] = arr[i] + k
 * 不幸地是，Alice 丢失了全部三个数组。但是，她记住了在数组 lower 和 higher 中出现的整数，但不知道每个整数属于哪个数组。请你帮助 Alice 还原原数组。
 * 给你一个由 2n 个整数组成的整数数组 nums ，其中 恰好 n 个整数出现在 lower ，剩下的出现在 higher ，还原并返回 原数组 arr 。如果出现答案不唯一的情况，返回 任一 有效数组。
 * 注意：生成的测试用例保证存在 至少一个 有效数组 arr 。
 * 提示：
 * 2 * n == nums.length
 * 1 <= n <= 1000
 * 1 <= nums[i] <= 10^9
 * 生成的测试用例保证存在 至少一个 有效数组 arr
 * @Date: 2021/12/26
 */

public class Solution4 {
    public int[] res;
    public Map<Integer, Integer> map;

    // 时间复杂度: O(n^2)
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        System.out.println("nums:" + Arrays.toString(nums));
        res = new int[nums.length / 2];
        for (int i = 1; i <= nums.length / 2; i++) {
            if (check((nums[i] - nums[0]) / 2, nums)) {
                return res;
            }
        }
        return new int[0];
    }

    private boolean check(int k, int[] nums) {
        if (k == 0) return false;
        map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int i = 0, j = 0;
        while (j < nums.length) {
            if (map.containsKey(nums[j])) {// 每次取nums数组中最小的元素，必然属于low
                int low = nums[j];
                int high = low + 2 * k;
                res[i++] = nums[j++] + k;
                if (map.containsKey(high) && map.containsKey(low)) {
                    if (map.get(high) == 1) map.remove(high);
                    else map.put(high, map.get(high) - 1);
                    if (map.get(low) == 1) map.remove(low);
                    else map.put(low, map.get(low) - 1);
                } else {
                    return false;
                }
            } else {
                j++;
            }
        }
        return true;
    }

    // 简洁写法
    public int[] recoverArray2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1, result[] = new int[nums.length / 2]; ; i++) {
            if (nums[i] > nums[0] && (nums[i] - nums[0]) % 2 == 0) {
                ArrayDeque<Integer> deque = new ArrayDeque<>();
                for (int j = 0, idx = 0; j < nums.length; j++) {
                    if (!deque.isEmpty() && deque.peek() == nums[j]) {
                        deque.poll();// 属于high数组，直接弹出队头
                    } else if (idx == result.length) {
                        break;
                    } else {
                        deque.offer(nums[j] + nums[i] - nums[0]);// high[j]，添加进队尾
                        result[idx++] = nums[j] + (nums[i] - nums[0]) / 2;// low[j] + k
                    }
                }
                if (deque.isEmpty()) return result;// 找到一个结果
            }
        }
    }


    public static void main(String[] args) {
//        int[] nums = {2, 10, 6, 4, 8, 12};
//        int[] nums = {1, 1, 3, 3};
//        int[] nums = {5, 435};
        int[] nums = {11, 6, 3, 4, 8, 7, 8, 7, 9, 8, 9, 10, 10, 2, 1, 9}; // [2,3,7,8,8,9,9,10]
        int[] res = (new Solution4()).recoverArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
