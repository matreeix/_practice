package _CONTEST._biweekly._38;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 1636. 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * @Author: matreeix
 * @Date: 2020/11/3
 */

public class Solution1 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, 1 + freq.getOrDefault(n, 0));
        }
        Queue<Integer> pq = new PriorityQueue<Integer>((i, j) -> freq.get(i) == freq.get(j) ? j - i : freq.get(i) - freq.get(j));
        for (int n : nums) {
            pq.offer(n);
        }
        int i = 0;
        int[] ans = new int[nums.length];
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
