package _leetcode._CONTEST._biweekly._68;

import java.util.*;

/**
 * @Description: 5947. 从给定原材料中找到所有可以做出的菜
 * 你有 n 道不同菜的信息。给你一个字符串数组 recipes 和一个二维字符串数组 ingredients 。第 i 道菜的名字为 recipes[i] ，如果你有它 所有 的原材料 ingredients[i] ，那么你可以 做出 这道菜。一道菜的原材料可能是 另一道 菜，也就是说 ingredients[i] 可能包含 recipes 中另一个字符串。
 * 同时给你一个字符串数组 supplies ，它包含你初始时拥有的所有原材料，每一种原材料你都有无限多。
 * 请你返回你可以做出的所有菜。你可以以 任意顺序 返回它们。
 * 注意两道菜在它们的原材料中可能互相包含。
 * 提示：
 * n == recipes.length == ingredients.length
 * 1 <= n <= 100
 * 1 <= ingredients[i].length, supplies.length <= 100
 * 1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
 * recipes[i], ingredients[i][j] 和 supplies[k] 只包含小写英文字母。
 * 所有 recipes 和 supplies 中的值互不相同。
 * ingredients[i] 中的字符串互不相同。
 * @Date: 2021/12/25
 */

public class Solution2 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(supplies));
        for (int i = 0; i < recipes.length; ) {
            i += set.containsAll(ingredients.get(i)) && set.add(recipes[i]) && list.add(recipes[i]) ? -i : 1;
        }
        return list;
    }

    public List<String> findAllRecipes2(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        HashMap<String, Integer> recMap = new HashMap<>();
        HashMap<String, ArrayList<String>> graph = new HashMap<>();//<原材料，菜>
        HashSet<String> sup = new HashSet<>(Arrays.asList(supplies));

        for (int i = 0; i < n; i++) recMap.put(recipes[i], i);
        int[] indegree = new int[n];// 记录用菜作为原材料的个数
        for (int i = 0; i < n; i++)
            for (String str : ingredients.get(i))
                if (!sup.contains(str)) {// 缺少原材料
                    graph.putIfAbsent(str, new ArrayList<>());
                    graph.get(str).add(recipes[i]);
                    indegree[i]++;// 增加入度
                }

        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)//能直接做成的菜作为拓扑排序的起点
                q.add(recipes[i]);

        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            String node = q.poll();
            ans.add(node);
            if (graph.containsKey(node)) {
                for (String str : graph.get(node)) {
                    indegree[recMap.get(str)]--;
                    if (indegree[recMap.get(str)] == 0)
                        q.add(str);
                }
            }
        }
        return ans;
    }
}

