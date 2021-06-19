package _leetcode._CONTEST._weekly._205;

/**
 * @Description: 5510. 保证图可完全遍历
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 * <p>
 * 类型 1：只能由 Alice 遍历。
 * 类型 2：只能由 Bob 遍历。
 * 类型 3：Alice 和 Bob 都可以遍历。
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。
 * 请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 * <p>
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 * @Author: matreeix
 * @Date: 2020/9/6
 */

public class Solutoin4 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int cnt1 = 0;
        int cnt2 = 0;
        int res = 0;
        UF uf = new UF(n + 1);
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (uf.union(edge[1], edge[2])) {
                    cnt1++;
                    cnt2++;
                } else {
                    res++;
                }
            }
        }
        int[] parentcpy = uf.parent.clone();
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (uf.union(edge[1], edge[2])) {
                    cnt1++;
                } else {
                    res++;
                }
            }
        }
        uf.parent = parentcpy;
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (uf.union(edge[1], edge[2])) {
                    cnt2++;
                } else {
                    res++;
                }
            }
        }
        return cnt1 == n - 1 && cnt2 == n - 1 ? res : -1;
    }
}

class UF {
    int[] parent;

    public UF(int n) {
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false;
        }
        parent[px] = py;
        return true;
    }

    private int find(int x) {
        return parent[x] = x == parent[x] ? x : find(parent[x]);
    }
}
