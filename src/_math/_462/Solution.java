package _math._462;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 462. 最少移动次数使数组元素相等 II
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * @Author: matreeix
 * @Date: 2020/9/22
 */

public class Solution {
    public int minMoves2(int[] nums) {
        int mid = getMid(nums);//得到的最后相等的元素值
        int res = 0;
        for (int num : nums)
            res += Math.abs(num - mid);

        return res;
    }

    //找到数组的中位数，偶数个取两者的平均值
    private int getMid(int[] nums) {
        int mid = 0;
        int heapSize = nums.length / 2 + 1;//维护一个大小为n/2+1的小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++)
            heap.add(nums[i]);

        for (int i = heapSize; i < nums.length; i++) {
            if (heap.peek() < nums[i]) {//比堆顶大就弹出堆顶并添加该元素
                heap.poll();
                heap.add(nums[i]);
            }
        }
        if (nums.length % 2 == 1) {
            mid = heap.peek();
        } else {
            mid = (heap.poll() + heap.peek()) / 2;
        }
        return mid;
    }


    //排序法
    public int minMoves22(int[] nums) {
        Arrays.sort(nums);
        int res = 0, l = 0, r = nums.length - 1;
        while(l < r)
            res += nums[r--] - nums[l++];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11};
        Solution s = new Solution();
        System.out.println(s.getMid(nums));
    }
}
