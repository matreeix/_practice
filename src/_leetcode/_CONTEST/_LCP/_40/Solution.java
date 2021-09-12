package _leetcode._CONTEST._LCP._40;

import java.util.Arrays;

/**
 * @Description: LCP 40. 心算挑战
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
 * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 * 提示：
 * <p>
 * 1 <= cnt <= cards.length <= 10^5
 * 1 <= cards[i] <= 1000
 * @Date: 2021/9/11
 */

public class Solution {
    /**
     * 1.有偶数个奇数
     * 2.
     */
    public static int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int res = 0;
        int even1 = -1, odd1 = -1, idx = cards.length - 1;
        while (cnt > 0) {
            if (cards[idx] % 2 == 0) {
                even1 = idx;
            } else {
                odd1 = idx;
            }
            res += cards[idx--];
            cnt--;
        }
        if (res % 2 == 0) return res;
        int even2 = -1, odd2 = -1;
        for (int i = idx; i > -1; i--) {
            if (cards[i] % 2 == 0) {
                even2 = even2 == -1 ? i : even2;
            } else {
                odd2 = odd2 == -1 ? i : odd2;
            }
        }

        if (odd2 != -1 && even2 != -1 && even1 != -1) {
            res = Math.max(res - cards[even1] + cards[odd2], res - cards[odd1] + cards[even2]);
        } else if (odd2 != -1 && even1 != -1) {
            res = res - cards[even1] + cards[odd2];
        } else if (even2 != -1) {
            res = res - cards[odd1] + cards[even2];
        } else {
            res = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 9};
        System.out.println(maxmiumScore(arr, 3));
    }
}
