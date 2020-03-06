package _greedy._45;

import java.util.Arrays;

/**
 * @Description: 跳跃游Ⅱ
 * @Author: 67ng
 * @Date: 2020/3/4
 */
public class Solution {
    //使用记忆化搜索
    public int jump(int[] nums) {
        //mem[i]表示达到第i个索引所需的最小步骤数
        int[] mem = new int[nums.length];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]
                    && j <= nums.length - 1 - i; j++) {
                mem[i + j] = Math.min(mem[i + j], 1 + mem[i]);
            }
        }
        System.out.println(Arrays.toString(mem));
        return mem[nums.length - 1];
    }

    //使用贪心算法
    public int jump2(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        //curFarthest是[curBegin，curEnd]中所有点能达到的最远点
        int curFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;

                if (curEnd >= nums.length - 1) break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println((new Solution()).jump(arr));
    }
}
