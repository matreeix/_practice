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
            return Double.compare(another.dis - dis, 0.0);
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

        //使用Dijkstra算法
        dis = new double[n];
        Arrays.fill(dis, 0.0);

        pre = new int[n];
        Arrays.fill(pre, -1);

        visited = new boolean[n];
        dis[start] = 1.0;
        pre[start] = start;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0.0));
        while (!pq.isEmpty()) {//用优先队列找到当前未访问的dis值最大的节点
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


    //更清晰的Dijkstra算法解法
    public double maxProbability2(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a, b) -> ((int) ((b[1] - a[1]) * 1000000000)));
        Map<Integer, Map<Integer, Double>> g = buildGraph(edges, succProb);
        pq.offer(new double[]{start, 1.0});
        Set<Integer> vs = new HashSet<>();
        Map<Integer, Double> probs = new HashMap<>();
        probs.put(start, 1.0);
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            if (vs.contains((int) curr[0])) continue;
            vs.add((int) curr[0]);
            if (((int) curr[0]) == end) return curr[1];
            for (int neig : g.getOrDefault((int) curr[0], new HashMap<>()).keySet()) {
                if (vs.contains(neig)) continue;
                double prob = curr[1] * g.get((int) curr[0]).get(neig);
                if (prob > probs.getOrDefault(neig, 0.0)) {
                    probs.put(neig, prob);
                    pq.offer(new double[]{neig, prob});
                }
            }
        }
        return 0;
    }

    private Map<Integer, Map<Integer, Double>> buildGraph(int[][] edges, double[] succProb) {
        Map<Integer, Map<Integer, Double>> g = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            g.computeIfAbsent(edges[i][0], k -> new HashMap<>());
            g.computeIfAbsent(edges[i][1], k -> new HashMap<>());
            g.get(edges[i][0]).put(edges[i][1], succProb[i]);
            g.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }
        return g;
    }

    /**
     * 使用BFS，思路：
     * 1.马尔可夫链
     * 2.简单来说，BFS在每个阶段都需要记住两件事：当前节点 + 该节点上的当前概率
     * 3.可以从多条路径到达一个节点，我们不能简单地使用访问数组或集合来避免重复。
     * 4.我们可以做的是记录“ 到目前为止每个节点的最佳概率 ”。然后仅在以下情况下添加到BFS队列中：它可以为该当前节点提供更好的概率。
     * <p>
     * linked：https://leetcode.com/problems/path-with-maximum-probability/discuss/731626/Java-Detailed-Explanation-BFS
     */
    class State {
        int node;
        double prob;

        State(int _node, double _prob) {
            node = _node;
            prob = _prob;
        }
    }

    public double maxProbability3(int n, int[][] edges, double[] succProb, int start, int end) {

        // build graph -> double[0]: node, double[1]: edge prob
        Map<Integer, List<double[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];

            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            map.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }

        double[] probs = new double[n];  // best prob so far for each node
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(start, 1.0));

        while (!queue.isEmpty()) {

            State state = queue.poll();
            int parent = state.node;
            double prob = state.prob;

            for (double[] child : map.getOrDefault(parent, new ArrayList<>())) {
                // add to queue only if: it can make a better prob
                if (probs[(int) child[0]] >= prob * child[1]) continue;

                queue.add(new State((int) child[0], prob * child[1]));
                probs[(int) child[0]] = prob * child[1];
            }
        }
        return probs[end];
    }

    public static void main(String[] args) {
//        int n = 3;
//        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
//        double[] succProb = {0.5, 0.5, 0.2};
//        int start = 0, end = 2;

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {4, 1}, {3, 2}, {4, 2}, {4, 5}, {3, 5}};
        double[] succProb = {0.2, 0.8, 0.1, 0.1, 0.5, 0.9, 0.2, 0.1};
        int start = 1, end = 5;

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxProbability(n, edges, succProb, start, end));//0.0288

    }
}