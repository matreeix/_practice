package _leetcode.heap._373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description: 373. 查找和最小的K对数字
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * @Created by: matreeix
 * @Date: 2021/5/3
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (nums1[o[0]] + nums2[o[1]])));
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0) return result;
        for (int i = 0; i < n1; i++)
            pq.offer(new int[]{i, 0});

        while (pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] < n2 - 1)//越界检查
                pq.offer(new int[]{pair[0], pair[1] + 1});//比较nums1[i]+nusm2[j]和nusm1[i]+nusm2[j+1]
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }
        return result;
    }


}
