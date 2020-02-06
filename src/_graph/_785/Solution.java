package _graph._785;

/**
 * @Description:二分图的检测
 * @Author: 67ng
 * @Date: 2020/2/5
 */
public class Solution {
    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {

        this.graph = graph;

        int V = graph.length;
        colors = new int[V];
        for (int i = 0; i < V; i++)
            colors[i] = -1;

        for (int v = 0; v < V; v++)
            if (colors[v] == -1)
                if (!dfs(v, 0)) return false;
        return true;
    }

    private boolean dfs(int v, int color) {

        colors[v] = color;
        for (int w : graph[v])
            if (colors[w] == -1) {
                if (!dfs(w, 1 - color)) return false;
            } else if (colors[v] == colors[w])
                return false;
        return true;
    }
}
