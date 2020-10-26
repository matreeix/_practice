package _CONTEST._weekly._212;

import javafx.util.Pair;

import java.util.*;

/**
 * @Description: 1632. 矩阵转换后的秩
 * 给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][col] 的秩。
 * <p>
 * 每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算：
 * <p>
 * 如果一个元素是它所在行和列的最小值，那么它的 秩 为 1。
 * 如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么：
 * 如果 p < q ，那么 rank(p) < rank(q)
 * 如果 p == q ，那么 rank(p) == rank(q)
 * 如果 p > q ，那么 rank(p) > rank(q)
 * 秩 需要越 小 越好。
 * 题目保证按照上面规则 answer 数组是唯一的。
 * @Author: matreeix
 * @Date: 2020/10/25
 */

class Solution4 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rank = new int[n + m];
        Map<Integer, List<Pair<Integer, Integer>>> invMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                invMap.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new Pair<>(i, j));
            }
        }
        List<Integer> keySet = new ArrayList<>(invMap.keySet());
        Collections.sort(keySet);
        for (int key : keySet) {
            UF uf = new UF(n + m);
            int[] rank2 = rank.clone();
            for (Pair<Integer, Integer> coord : invMap.get(key)) {
                Pair<Integer, Integer> res = uf.union(coord.getKey(), coord.getValue() + n);
                rank2[res.getValue()] = Math.max(rank2[res.getValue()], rank2[res.getKey()]);
            }
            for (Pair<Integer, Integer> coord : invMap.get(key)) {
                rank[coord.getKey()] = rank[coord.getValue() + n] = matrix[coord.getKey()][coord.getValue()] = rank2[uf.find(coord.getKey())] + 1;
            }
        }
        return matrix;
    }
}

class UF {
    int[] parent;

    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int x) {
        return parent[x] = parent[x] == x ? x : find(parent[x]);
    }

    public Pair<Integer, Integer> union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parent[px] = py;
        return new Pair<>(px, py);
    }
}
