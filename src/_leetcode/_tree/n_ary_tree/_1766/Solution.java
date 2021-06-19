package _leetcode._tree.n_ary_tree._1766;

import java.util.*;

/**
 * @Description: 1766. 互质树
 * 给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 号点。
 * 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节点 uj 和节点 vj 在树中有一条边。
 * 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。
 * 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。
 * 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 ，如果不存在这样的祖先节点，ans[i] 为 -1 。
 * @Date: 2021/2/23
 */

public class Solution {
    private boolean[] visited;
    private TreeSet<Integer>[] adj;
    private Map<Integer, LinkedList<Integer>> map;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        adj = new TreeSet[n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++)
            adj[i] = new TreeSet<Integer>();

        visited = new boolean[n];
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        bfs(0);
        System.out.println(map);
        for (int v : map.keySet()) {
            LinkedList<Integer> list = map.get(v);
            for (int w : list) {
                if (gcd(nums[v], nums[w]) == 1) {
                    ans[v] = w;
                    break;
                }
            }
        }
        return ans;
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : adj[v])
                if (!visited[w]) {
                    LinkedList<Integer> tmp = (LinkedList<Integer>) map.getOrDefault(v, new LinkedList<>()).clone();
                    tmp.addFirst(v);
                    map.put(w, tmp);
                    queue.add(w);
                    visited[w] = true;
                }
        }
    }

    //欧几里得算法,计算最大公约数
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


    public void dfs(int[] nums, LinkedList<Integer>[] tree, int depth, int node, boolean[] visited, int[] ans, Map<Integer, int[]> map, boolean[][] poss) {
        if (visited[node]) return;
        visited[node] = true;
        int ancestor = -1;
        int d = Integer.MAX_VALUE;
        for (int i = 1; i < 51; i++) {
            if (poss[nums[node]][i] && map.containsKey(i)) {
                if (depth - map.get(i)[0] <= d) {
                    d = depth - map.get(i)[0];
                    ancestor = map.get(i)[1];
                }
            }
        }
        ans[node] = ancestor;
        int[] exist = (map.containsKey(nums[node])) ? map.get(nums[node]) : new int[]{-1, -1};
        map.put(nums[node], new int[]{depth, node});
        for (int child : tree[node]) {
            if (visited[child]) continue;
            dfs(nums, tree, depth + 1, child, visited, ans, map, poss);
        }
        if (exist[0] != -1) map.put(nums[node], exist);
        else map.remove(nums[node]);

        return;
    }

    public int[] getCoprimes2(int[] nums, int[][] edges) {
        boolean[][] poss = new boolean[51][51];
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (gcd(i, j) == 1) {
                    poss[i][j] = true;
                    poss[j][i] = true;
                }
            }
        }
        int n = nums.length;
        LinkedList<Integer>[] tree = new LinkedList[n];

        for (int i = 0; i < tree.length; i++) tree[i] = new LinkedList<>();
        for (int edge[] : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = -1;
        Map<Integer, int[]> map = new HashMap<>();

        boolean[] visited = new boolean[n];
        dfs(nums, tree, 0, 0, visited, ans, map, poss);
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {5, 6, 10, 2, 3, 6, 15};
//        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};//[-1,0,-1,0,0,0,-1]
        int[] nums = {2, 3, 3, 2};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getCoprimes(nums, edges)));
    }
}
