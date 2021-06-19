package _leetcode._CONTEST._biweekly._33;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 5480. 可以到达所有点的最少点数目
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 * 你可以以任意顺序返回这些节点编号。
 * @Author: matreeix
 * @Date: 2020/8/22
 */

public class Solution2 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : edges) {
            int a = list.get(0);
            int b = list.get(1);
            visited[a] = true;
            visited[b] = true;
            set.remove(b);
            if (!visited[a]) set.add(a);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : set)
            res.add(i);

        return res;
    }

    //返回所有没有入度的点即可
    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        int[] seen = new int[n];
        for (List<Integer> e : edges)
            seen[e.get(1)] = 1;
        for (int i = 0; i < n; ++i)
            if (seen[i] == 0)
                res.add(i);
        return res;
    }


    public static void main(String[] args) {

    }
}
