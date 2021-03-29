package _tree.n_ary_tree._690;

import java.util.*;

/**
 * @Description: 690. 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，
 * 员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 * <p>
 * 提示：
 * <p>
 * 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
 * 员工数量不超过 2000 。
 * @Date: 2021/3/29
 */

public class Solution {

    private class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    private int res = 0;

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) return 0;
        Map<Integer, Employee> map = new HashMap();
        for (Employee e : employees) map.put(e.id, e);
        dfs(id, map);
        return res;
    }

    private void dfs(int id, Map<Integer, Employee> map) {
        Employee e = map.get(id);
        res += e.importance;
        for (int i : e.subordinates) dfs(i, map);//由于是颗多叉树，不用判断是否访问
    }


    public int getImportance2(List<Employee> employees, int id) {

        Employee[] e = new Employee[2001];
        for (Employee t : employees) e[t.id] = t;//id越界就不能这么用
        return DFS(e, id);
    }

    public int DFS(Employee[] e, int id) {
        if (e[id] == null)
            return 0;

        int ans = e[id].importance;
        for (int t : e[id].subordinates) {
            ans += DFS(e, t);
        }

        return ans;
    }
}
