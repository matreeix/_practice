package _leetcode._graph._684;

/**
 * @Description: 684. 冗余连接
 * 树可以看成是一个连通且 无环 的 无向 图。
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
 * 图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 * <p>
 * 提示:
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的 
 * @Date: 2021/7/21
 */

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            /**
             * 如果两个顶点属于不同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间不连通，因此当前的边不会导致环出现，合并这两个顶点的连通分量。
             * */
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {//如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，因此当前的边导致环出现，为附加的边，将当前的边作为答案返回。
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}

