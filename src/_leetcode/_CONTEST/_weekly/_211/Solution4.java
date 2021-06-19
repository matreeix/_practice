package _leetcode._CONTEST._weekly._211;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 1627. 带阈值的图连通性
 * 有 n 座城市，编号从 1 到 n 。编号为 x 和 y 的两座城市直接连通的前提是： x 和 y 的公因数中，至少有一个 严格大于 某个阈值 threshold 。更正式地说，如果存在整数 z ，且满足以下所有条件，则编号 x 和 y 的城市之间有一条道路：
 * <p>
 * x % z == 0
 * y % z == 0
 * z > threshold
 * 给你两个整数 n 和 threshold ，以及一个待查询数组，请你判断每个查询 queries[i] = [ai, bi] 指向的城市 ai 和 bi 是否连通（即，它们之间是否存在一条路径）。
 * <p>
 * 返回数组 answer ，其中answer.length == queries.length 。如果第 i 个查询中指向的城市 ai 和 bi 连通，则 answer[i] 为 true ；如果不连通，则 answer[i] 为 false 。
 * @Author: matreeix
 * @Date: 2020/10/24
 */

public class Solution4 {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 1; i <= n; i++)
            for (int j = i * 2; j <= n; j += i)
                if (i > threshold)
                    uf.union(i, j);
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int pa = uf.find(q[0]);
            int pb = uf.find(q[1]);
            ans.add(pa == pb);
        }
        return ans;
    }
}


// Feel free to copy this class for later reuse!
class UnionFind {
    int[] parent, size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); // Path compression
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (size[pu] > size[pv]) { // Union by larger size
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        return true;
    }
}
