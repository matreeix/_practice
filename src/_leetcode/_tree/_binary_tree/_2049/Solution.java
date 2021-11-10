package _leetcode._tree._binary_tree._2049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 2049. 统计最高分的节点数目
 * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，
 * 其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
 * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
 * 请你返回有 最高得分 节点的 数目 。
 * @Date: 2021/11/9
 */

public class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        int[] cnt = new int[n];
        cnt[0] = n;
        Map<Integer, List<Integer>> map = new HashMap<>();// <father,son>
        for (int i = 0; i < n; i++) {
            if (map.containsKey(parents[i])) {
                List<Integer> son = map.get(parents[i]);
                son.add(i);
            } else {
                int son = i;
                map.put(parents[i], new ArrayList<Integer>() {{
                    add(son);
                }});
            }
        }
        getCnt(0, cnt, map);
        long max = n - 1;
        long[] cntSum = new long[n];
        for (int i = 0; i < cnt.length; i++) {
            if (map.get(i) == null) {
                cntSum[i] = n - 1;
            } else {
                int lCnt = cnt[map.get(i).get(0)];
                int rCnt = 1;
                if (map.get(i).size() > 1) rCnt = cnt[map.get(i).get(1)];
                int pCnt = n - cnt[i];
                if (parents[i] == -1) pCnt = 1;
                cntSum[i] = (long) lCnt * rCnt * pCnt;
                max = Math.max(max, cntSum[i]);
            }
        }

        int res = 0;
        for (long s : cntSum)
            if (s == max)
                res++;
        return res;
    }

    private void getCnt(int node, int[] cnt, Map<Integer, List<Integer>> map) {
        if (map.get(node) == null) {
            cnt[node] = 1;
            return;
        }
        int l = map.get(node).get(0);
        getCnt(l, cnt, map);
        if (map.get(node).size() > 1) {
            int r = map.get(node).get(1);
            getCnt(r, cnt, map);
            cnt[node] = cnt[l] + cnt[r] + 1;
        } else {
            cnt[node] = cnt[l] + 1;
        }
    }
}
