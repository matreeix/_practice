package _UF._721;

import java.util.*;

/**
 * @Description: 账户合并
 * @Author: matreeix
 * @Date: 2020/6/3
 */
public class Solution {
    //DFS，时间复杂度O(Σ（len * loglen）)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account : accounts) {
            String name = "";//存储账号名
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {//使用DFS来遍历
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei : graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

    //使用并查集，时间复杂度约为O(∑len)
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";//存储账号名
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x -> new ArrayList()).add(email);
        }
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {

    }
}

class DSU {
    int[] parent;//存储父节点
    int[] rank;//维持树的平衡性

    public DSU() {
        parent = new int[10001];
        rank = new int[10001];
        for (int i = 0; i <= 10000; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //查找根节点
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    //合并节点
    public void union(int x, int y) {
//        parent[find(x)] = find(y);
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot)
            return;

        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else { // rank[pRoot] == rank[qRoot]
            parent[xRoot] = yRoot;
            rank[yRoot] += 1;   // 此时, 我维护rank的值
        }
    }

}
