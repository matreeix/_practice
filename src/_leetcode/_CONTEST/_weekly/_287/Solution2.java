package _leetcode._CONTEST._weekly._287;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 5235. 找出输掉零场或一场比赛的玩家
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 * 返回一个长度为 2 的列表 answer ：
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * 注意：
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * 提示：
 * 1 <= matches.length <= 10^5
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 10^5
 * winneri != loseri
 * 所有 matches[i] 互不相同
 * @Date: 2022/4/4
 */

public class Solution2 {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[][] cnts = new int[100001][2];
        for (int[] match : matches) {
            cnts[match[0]][0]++;
            cnts[match[1]][1]++;
        }
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i][0] > 0 && cnts[i][1] == 0) ans1.add(i);
            if (cnts[i][1] == 1) ans2.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
