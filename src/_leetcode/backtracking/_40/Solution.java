package _leetcode.backtracking._40;

import java.util.*;

/**
 * @Description: 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次
 * @Date: 2021/3/30
 */

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);//很关键
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
        if (remain < 0) return; /** no solution */
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < cand.length; i++) {
                /**
                 * 如何跳过重复（剪枝）:
                 * 1. 由于已经排序了，所以不同元素组合回溯是不可能会重复的，仅考虑相同元素的重复情况即可 （cand[i] == cand[i - 1]）
                 * 2.i > start ，说明俩次回溯在一个for循环内即一个递归层级，如下图所示：
                 *         1                         1
                 *        / \                       /
                 *       2   2                     2
                 *      /     \                   /
                 *     5       5                 2
                 *        例1                      例2
                 * 例1就是重复组合的情况，例2是允许的。  （i > start）
                 *
                 * */
                if (i > start && cand[i] == cand[i - 1]) continue;
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain - cand[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
