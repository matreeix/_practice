package _leetcode._CONTEST._biweekly._67;

import java.util.*;

/**
 * @Description: 5936. 引爆最多的炸弹
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 * 提示：
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 10^5
 * @Date: 2021/12/11
 */

public class Solution3 {
    public int ans = 1;
    public Map<Long, List<Long>> map;
    public Map<Long, Integer> freqMap;
    public Set<Long> vis;

    public int maximumDetonation(int[][] bombs) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        vis = new HashSet<>();
        long mod = 100001L;
        for (int i = 0; i < bombs.length; i++) {
            long b1 = bombs[i][0] * mod * mod + bombs[i][1] * mod + bombs[i][2];
            freqMap.put(b1, freqMap.getOrDefault(b1, 0) + 1);
            for (int j = i + 1; j < bombs.length; j++) {
                long dis = (long) (bombs[i][0] - bombs[j][0]) * (bombs[i][0] - bombs[j][0]) + (long) (bombs[i][1] - bombs[j][1]) * (bombs[i][1] - bombs[j][1]);
                long b2 = bombs[j][0] * mod * mod + bombs[j][1] * mod + bombs[j][2];
                if (dis <= (long) bombs[i][2] * bombs[i][2]) {
                    map.putIfAbsent(b1, new ArrayList<>());
                    map.get(b1).add(b2);
                }
                if (dis <= (long) bombs[j][2] * bombs[j][2]) {
                    map.putIfAbsent(b2, new ArrayList<>());
                    map.get(b2).add(b1);
                }
            }
        }

        for (long key : map.keySet()) {
            dfs(key);
            int cnt = 0;
            for (long b : vis) {
                cnt += freqMap.get(b);
            }
            ans = Math.max(ans, cnt);
            vis.clear();
        }
        return ans;
    }

    private void dfs(long cur) {
        vis.add(cur);
        if (map.containsKey(cur))
            for (long next : map.get(cur))
                if (!vis.contains(next))
                    dfs(next);
    }


    public static void main(String[] args) {
        int[][] bombs = {{1, 1, 100000}, {100000, 100000, 1}};
        System.out.println((new Solution3()).maximumDetonation(bombs));
    }
}
