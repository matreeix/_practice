package _leetcode._CONTEST._biweekly._73;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 2192. 有向无环图中一个节点的所有祖先
 * 给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
 * 给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
 * 请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
 * 如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。
 * 提示：
 * 1 <= n <= 1000
 * 0 <= edges.length <= min(2000, n * (n - 1) / 2)
 * edges[i].length == 2
 * 0 <= fromi, toi <= n - 1
 * fromi != toi
 * 图中不会有重边。
 * 图是 有向 且 无环 的。
 * @Date: 2022/3/8
 */

public class Solution3 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> parents = new HashMap<>();
        for (int i = 0; i < n; i++) parents.put(i, new ArrayList<>());
        for (int[] edge : edges) parents.get(edge[1]).add(edge[0]);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> parent = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int index = queue.poll();
                if (index != i) parent.add(index);
                for (Integer id : parents.get(index)) {
                    if (!parent.contains(id)) {
                        queue.offer(id);
                    }
                }
            }
            result.add(parent.stream().sorted().collect(Collectors.toList()));
        }
        return result;
    }
}
