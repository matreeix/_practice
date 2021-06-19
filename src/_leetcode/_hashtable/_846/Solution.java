package _leetcode._hashtable._846;

import java.util.*;

/**
 * @Description: 846. 一手顺子
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * 如果她可以完成分组就返回 true，否则返回 false。
 * @Date: 2021/3/21
 */

public class Solution {

    //有序map，时间复杂度：O(N * (N/W))
    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) return true;
        int n = hand.length;
        if (n % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand)
            map.put(i, map.getOrDefault(i, 0) + 1);
        while (map.size() > 0) {
            int first = map.firstKey();
            for (int card = first; card < first + W; ++card) {//每次从最小的牌得到一组长度为w的牌
                if (!map.containsKey(card)) return false;
                int c = map.get(card);
                if (c == 1) map.remove(card);
                else map.replace(card, c - 1);
            }
        }
        return true;
    }

    //排序
    public boolean isNStraightHand2(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) return false;
        Arrays.sort(hand);
        boolean[] taken = new boolean[len];//标记元素是否使用
        for (int i = 0; i < len; i++) {
            if (taken[i]) continue;
            taken[i] = true;
            int cur = hand[i] + 1;//当前组最小值加一，和初始化的j对照
            int end = hand[i] + W - 1;
            // 直接冲下一个位置开始遍历，因为用的hand那么hand[i]必定存在值
            int j = i + 1;
            while (cur <= end && j < len) {//找到一组值
                if (hand[j] == cur && !taken[j]) {//跳过重复值
                    cur++;
                    taken[j] = true;
                }
                j++;
            }
            if (cur != end + 1) return false;//能找完一组值，cur必然等于end+1，否则就是不够，返回false
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        Solution s = new Solution();
        System.out.println(s.isNStraightHand2(hand, W));
    }

}
