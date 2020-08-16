package _CONTEST._weekly._202;

import java.util.Arrays;

/**
 * @Description: 5489. 两球之间的磁力
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 * Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 * @Author: matreeix
 * @Date: 2020/8/15
 */

public class Solution3 {
    //使用二分查找
    //linked:https://leetcode.com/problems/magnetic-force-between-two-balls/discuss/794176/Java-binary-search
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0;
        int r = position[position.length - 1];
        int len = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(position, m, mid)) {//能放下m个球，就扩大距离
                len = mid;
                l = mid + 1;
            } else {//放不下，就缩小距离
                r = mid - 1;
            }
        }
        return len;
    }

    /**
     * 判断是否可以放m个球，使任意两个球之间的最小距离不小于max
     */
    private boolean check(int[] positions, int m, int max) {
        int count = 1;
        int last = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= max) {//贪心，尽量多放球
                last = positions[i];
                count++;
            }
        }
        return count >= m;
    }

}
