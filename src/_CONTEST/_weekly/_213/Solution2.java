package _CONTEST._weekly._213;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 1642. 可以到达的最远建筑
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * <p>
 * 1.如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 2.如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * @Author: matreeix
 * @Date: 2020/11/1
 */

public class Solution2 {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int[] diff = new int[n];//记录上升的差值
        int[] idxs = new int[n];//记录对应索引
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if (heights[i + 1] > heights[i]) {
                diff[idx] = heights[i + 1] - heights[i];
                idxs[idx] = i;
                idx++;
            }
        }

        Queue<Integer> q = new PriorityQueue<>();//维护一个大小为ladders的小根堆
        for (int i = 0; diff[i] > 0; i++) {
            if (ladders-- > 0) {
                q.add(diff[i]);
            } else {
                q.add(diff[i]);
                bricks -= q.poll();
                if (bricks < 0) {
                    return idxs[i];
                }
            }
        }
        return n - 1;
    }

    //精简版
    public int furthestBuilding2(int[] A, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.length - 1; i++) {
            int d = A[i + 1] - A[i];
            if (d > 0)
                pq.add(d);
            if (pq.size() > ladders)
                bricks -= pq.poll();
            if (bricks < 0)
                return i;
        }
        return A.length - 1;
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 7, 6, 9, 14, 12};
        int[] heights2 = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int[] heights3 = {14, 3, 19, 3};
        int bricks1 = 5, ladders1 = 1;
        int bricks2 = 10, ladders2 = 2;
        int bricks3 = 17, ladders3 = 0;
        System.out.println(furthestBuilding(heights1, bricks1, ladders1));//4
        System.out.println(furthestBuilding(heights2, bricks2, ladders2));//7
        System.out.println(furthestBuilding(heights3, bricks3, ladders3));//3
    }

}
