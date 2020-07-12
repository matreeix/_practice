package _CONTEST._weekly._197;

import java.util.*;

/**
 * @Description: Path with Maximum Probability
 * <p>
 * You are given an undirected weighted graph of n nodes (0-indexed),
 * represented by an edge list where edges[i] = [a, b] is an undirected edge
 * connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 * Given two nodes start and end, find the path with the maximum probability
 * of success to go from start to end and return its success probability.
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.
 * @Author: Pythagodzilla
 * @Date: 2020/7/12
 */

public class Solution3 {
    private boolean[] visited;
    private TreeSet<Integer>[] adj;//邻接表
    private Map<Integer, Double> prob;//构造哈希函数，存储边权重，只适用于节点数小于10000的情况
    private double[] dp;
    //    private double[][] dis;//两节点间的最大概率
    private double[] dis;//其他节点距离start节点的最大概率
    private double[] disStart;//其他节点距离start节点的最大概率
    //    private double[] pre;//前置节点概率
    private int[] pre;//前置节点

    private class Node implements Comparable<Node> {
        public int v;
        public double dis;

        public Node(int v, double dis) {
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node another) {//优先队列据此方法排序
            return (int) (dis - another.dis);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        visited = new boolean[n];
        prob = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            prob.put(edges[i][0] * 10000 + edges[i][1], succProb[i]);//边->权重
        }
        adj = new TreeSet[n];
        for (int i = 0; i < n; i++)
            adj[i] = new TreeSet<Integer>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        dis = new double[n];
        Arrays.fill(dis, 0.0);

        pre = new int[n];
        Arrays.fill(pre, -1);

        visited = new boolean[n];
        dis[start] = 1.0;
        pre[start] = start;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0.0));
        while (!pq.isEmpty()) {//用优先队列找到当前未访问的dis值最小的节点
            int cur = pq.remove().v;
            if (visited[cur]) continue;//已访问的节点跳到下一个循环

            visited[cur] = true;
            for (int w : adj[cur])
                if (!visited[w]) {
                    if (dis[cur] * getProb(cur, w) > dis[w]) {
                        dis[w] = dis[cur] * getProb(cur, w);
                        pq.add(new Node(w, dis[w]));
                        pre[w] = cur;
                    }
                }
        }
        return dis[end];
    }
/** Bellman-Ford算法，依然超时
 disStart = new double[n];
 Arrays.fill(disStart, 0.0);
 disStart[start] = 1.0;

 pre = new double[n];
 Arrays.fill(pre, -1);

 for (int pass = 1; pass < n; pass++) {
 for (int v = 0; v < n; v++)
 for (int w : adj[v])
 if (disStart[v] != 0.0 &&
 disStart[v] * getProb(v, w) > disStart[w]) {
 disStart[w] = disStart[v] * getProb(v, w);
 pre[w] = v;
 }
 }
 return disStart[end];*/
    /**
     * 使用弗洛伊德算法会超时
     * dis = new double[n][n];
     * for (int v = 0; v < n; v++)
     * Arrays.fill(dis[v], 0.0);
     * <p>
     * for (int v = 0; v < n; v++) {
     * dis[v][v] = 1.0;
     * for (int w : adj[v])
     * dis[v][w] = getProb(v, w);
     * }
     * <p>
     * <p>
     * for (int t = 0; t < n; t++)//中间点
     * for (int v = 0; v < n; v++)//起始点
     * for (int w = 0; w < n; w++)//终止点
     * if (dis[v][t] != 0.0//防止溢出
     * && dis[t][w] != 0.0
     * && dis[v][t] * dis[t][w] > dis[v][w])//松弛操作
     * dis[v][w] = dis[v][t] * dis[t][w];
     */

    //得到两节点间的权重
    private double getProb(int a, int b) {
        if (prob.containsKey(a * 10000 + b))
            return prob.get(a * 10000 + b);
        else
            return prob.getOrDefault(b * 10000 + a, 0.0);
    }

    /**
     * 尝试用dfs及bfs及dp进行求解，然并卵
     */
    /*    private void dfs(int v) {
        visited[v] = true;
        for (int w : adj[v])
            if (!visited[w])
                dfs(w);
    }

    private void bfs(int v, double[] dp) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int v2 = queue.remove();
            for (int w : adj[v2])
                if (dp[w] == 0.0) {
                    dp[w] = Math.max(dp[w], dp[v2] * getProb(v2, w));
                    queue.add(w);
                }
        }
    }*/
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0, end = 2;

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxProbability(n, edges, succProb, start, end));
    }
}