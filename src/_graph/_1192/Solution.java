package _graph._1192;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:查找集群内的关键连接点（寻找桥）
 *
 * 力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
 *
 * 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。
 *
 * 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
 *
 * 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
 *
 * 请你以任意顺序返回该集群内的所有 「关键连接」
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/critical-connections-in-a-network
 *
 * @Author: matreeix
 * @Date: 2020/2/8
 */
public class Solution {
    public class Graph {

        private int V;
        private int E;
        private ArrayList<Integer>[] adj;

        public Graph(int V){

            this.V = V;
            if(V < 0) throw new IllegalArgumentException("V must be non-negative");
            adj = new ArrayList[V];
            for(int i = 0; i < V; i ++)
                adj[i] = new ArrayList<Integer>();

            E = 0;
        }

        public void addEdge(int v, int w){

            validateVertex(v);
            validateVertex(w);

            if(adj[v].contains(w)) return;

            adj[v].add(w);
            adj[w].add(v);
            E ++;
        }

        public void validateVertex(int v){
            if(v < 0 || v >= V)
                throw new IllegalArgumentException("vertex " + v + "is invalid");
        }

        public int V(){
            return V;
        }

        public int E(){
            return E;
        }

        public Iterable<Integer> adj(int v){
            validateVertex(v);
            return adj[v];
        }
    }

    public class FindBridges {

        private Graph G;
        private boolean[] visited;

        private int ord[];
        private int low[];
        private int cnt;

        private List<List<Integer>> res;

        public FindBridges(Graph G){

            this.G = G;
            visited = new boolean[G.V()];

            res = new ArrayList<>();
            ord = new int[G.V()];
            low = new int[G.V()];
            cnt = 0;

            for(int v = 0; v < G.V(); v ++)
                if(!visited[v])
                    dfs(v, v);
        }

        private void dfs(int v, int parent){

            visited[v] = true;
            ord[v] = cnt;
            low[v] = ord[v];
            cnt ++;

            for(int w: G.adj(v))
                if(!visited[w]){
                    dfs(w, v);
                    low[v] = Math.min(low[v], low[w]);
                    if(low[w] > ord[v]){
                        ArrayList<Integer> edge = new ArrayList<>();
                        edge.add(v);
                        edge.add(w);
                        res.add(edge);
                    }
                }
                else if(w != parent)
                    low[v] = Math.min(low[v], low[w]);
        }

        public List<List<Integer>> result(){
            return res;
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Graph g = new Graph(n);
        for(List<Integer> edge: connections)
            g.addEdge(edge.get(0), edge.get(1));

        FindBridges fb = new FindBridges(g);
        return fb.result();
    }


}
