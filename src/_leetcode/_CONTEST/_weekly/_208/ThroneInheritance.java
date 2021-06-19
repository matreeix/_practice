package _leetcode._CONTEST._weekly._208;

import java.util.*;

/**
 * @Description: 5525. 皇位继承顺序
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 *
 * 这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。我们定义递归函数 Successor(x, curOrder) ，给定一个人 x 和当前的继承顺序，该函数返回 x 的下一继承人。
 *
 * Successor(x, curOrder):
 *     如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
 *         如果 x 是国王，那么返回 null
 *         否则，返回 Successor(x 的父亲, curOrder)
 *     否则，返回 x 不在 curOrder 中最年长的孩子
 * 比方说，假设王国由国王，他的孩子 Alice 和 Bob （Alice 比 Bob 年长）和 Alice 的孩子 Jack 组成。
 *
 * 一开始， curOrder 为 ["king"].
 * 调用 Successor(king, curOrder) ，返回 Alice ，所以我们将 Alice 放入 curOrder 中，得到 ["king", "Alice"] 。
 * 调用 Successor(Alice, curOrder) ，返回 Jack ，所以我们将 Jack 放入 curOrder 中，得到 ["king", "Alice", "Jack"] 。
 * 调用 Successor(Jack, curOrder) ，返回 Bob ，所以我们将 Bob 放入 curOrder 中，得到 ["king", "Alice", "Jack", "Bob"] 。
 * 调用 Successor(Bob, curOrder) ，返回 null 。最终得到继承顺序为 ["king", "Alice", "Jack", "Bob"] 。
 * 通过以上的函数，我们总是能得到一个唯一的继承顺序。
 *
 * 请你实现 ThroneInheritance 类：
 *
 * ThroneInheritance(string kingName) 初始化一个 ThroneInheritance 类的对象。国王的名字作为构造函数的参数传入。
 * void birth(string parentName, string childName) 表示 parentName 新拥有了一个名为 childName 的孩子。
 * void death(string name) 表示名为 name 的人死亡。一个人的死亡不会影响 Successor 函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
 * string[] getInheritanceOrder() 返回 除去 死亡人员的当前继承顺序列表。
 * @Author: matreeix
 * @Date: 2020/9/27
 */

public class ThroneInheritance {

    Map<String, List<String>> map;
    Set<String> set;
    String king;
    public ThroneInheritance(String kingName) {
        map = new HashMap();
        set = new HashSet();
        map.putIfAbsent(kingName, new ArrayList());
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        map.get(parentName).add(childName);
        map.putIfAbsent(childName, new ArrayList());
    }

    public void death(String name) {
        set.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList();
        dfs(king, result);
        return result;
    }

    private void dfs(String root, List<String> result) {
        if(!set.contains(root))
            result.add(root);
        for(String child : map.get(root))
            dfs(child, result);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
