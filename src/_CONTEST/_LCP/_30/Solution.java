package _CONTEST._LCP._30;

import java.util.PriorityQueue;

/**
 * @Description: LCP 30. 魔塔游戏
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。
 * 每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 * 小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，
 * 小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
 * @Created by: matreeix
 * @Date: 2021/6/18
 */
public class Solution {

    public int magicTower(int[] nums) {
        long sum = 1;
        int[] copy = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            copy[i] = nums[i];
        }
        if (sum <= 0) return -1;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int vis = 0, cnt = 0;
        long tmp = 1;
        int idx = nums.length;
        for (int num : copy) {
            if (num < 0) q.offer(num);
            tmp += num;
            if (tmp <= 0) {
                int min = q.poll();
                tmp -= min;
                vis--;
                cnt++;
                copy[idx++] = min;
            }
            vis++;
            if (vis == nums.length) return cnt;
        }
        return -1;
    }
}
