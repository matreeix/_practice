package _leetcode._design._1993;

import java.util.*;

/**
 * @Description: 1993. 树上的操作
 * 给你一棵 n 个节点的树，编号从 0 到 n - 1 ，以父节点数组 parent 的形式给出，其中 parent[i] 是第 i 个节点的父节点。树的根节点为 0 号节点，所以 parent[0] = -1 ，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。
 * <p>
 * 数据结构需要支持如下函数：
 * <p>
 * Lock：指定用户给指定节点 上锁 ，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
 * Unlock：指定用户给指定节点 解锁 ，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
 * Upgrade：指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁 。只有如下 3 个条件 全部 满足时才能执行升级操作：
 * 指定节点当前状态为未上锁。
 * 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
 * 指定节点没有任何上锁的祖先节点。
 * 请你实现 LockingTree 类：
 * <p>
 * LockingTree(int[] parent) 用父节点数组初始化数据结构。
 * lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
 * unlock(int num, int user) 如果 id 为 user 的用户可以给节点 num 解锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 变为 未上锁 状态。
 * upgrade(int num, int user) 如果 id 为 user 的用户可以给节点 num 升级，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 升级 。
 * @Date: 2021/9/6
 */

public class LockingTree {
    private Map<Integer, List<Integer>> parents;
    private int[] parent;
    private int[] users;

    public LockingTree(int[] parent) {
        this.parents = new HashMap<>();
        this.parent = parent;
        this.users = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            if (parents.containsKey(parent[i])) {
                List<Integer> tmp = parents.get(parent[i]);
                tmp.add(i);
            } else {
                int finalI = i;
                parents.put(parent[i], new ArrayList<Integer>() {{
                    add(finalI);
                }});
            }
        }
    }

    public boolean lock(int num, int user) {
        if (users[num] == 0) {
            users[num] = user;
            return true;
        } else {
            return false;
        }
    }

    public boolean unlock(int num, int user) {
        if (users[num] == user) {
            users[num] = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean upgrade(int num, int user) {
        if (users[num] != 0) return false;// 1.当前节点已经上锁
        List<Integer> locked = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (users[tmp] != 0) {
                locked.add(tmp);
            }
            List<Integer> sons = parents.get(tmp);
            if (sons != null) {
                for (int son : sons) {
                    q.add(son);
                }
            }
        }
        if (locked.size() == 0) return false;// 2.子孙节点都未上锁
        int init = parent[num];
        while (init != -1) {
            if (users[init] != 0) {// 3.存在上锁的祖先节点
                return false;
            }
            init = parent[init];
        }
        for (int son : locked) {
            users[son] = 0;
        }
        users[num] = user;
        return true;
    }
}
