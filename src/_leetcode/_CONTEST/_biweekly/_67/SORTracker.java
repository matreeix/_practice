package _leetcode._CONTEST._biweekly._67;

import javafx.util.Pair;

import java.util.*;

/**
 * @Description: 5937. 序列顺序查询
 * 一个观光景点由它的名字 name 和景点评分 score 组成，其中 name 是所有观光景点中 唯一 的字符串，score 是一个整数。景点按照最好到最坏排序。
 * 景点评分 越高 ，这个景点越好。如果有两个景点的评分一样，那么 字典序较小 的景点更好。
 * 你需要搭建一个系统，查询景点的排名。初始时系统里没有任何景点。这个系统支持：
 * 添加 景点，每次添加 一个 景点。
 * 查询 已经添加景点中第 i 好 的景点，其中 i 是系统目前位置查询的次数（包括当前这一次）。
 * 比方说，如果系统正在进行第 4 次查询，那么需要返回所有已经添加景点中第 4 好的。
 * 注意，测试数据保证 任意查询时刻 ，查询次数都 不超过 系统中景点的数目。
 * 请你实现 SORTracker 类：
 * SORTracker() 初始化系统。
 * void add(string name, int score) 向系统中添加一个名为 name 评分为 score 的景点。
 * string get() 查询第 i 好的景点，其中 i 是目前系统查询的次数（包括当前这次查询）。
 * 提示：
 * name 只包含小写英文字母，且每个景点名字互不相同。
 * 1 <= name.length <= 10
 * 1 <= score <= 10^5
 * 任意时刻，调用 get 的次数都不超过调用 add 的次数。
 * 总共 调用 add 和 get 不超过 4 * 10^4
 * @Date: 2021/12/12
 */

public class SORTracker {
    public int idx = 1;
    public PriorityQueue<Pair<String, Integer>> min;// 小根堆
    public PriorityQueue<Pair<String, Integer>> max;// 大根堆

    public SORTracker() {
        this.min = new PriorityQueue<>((p1, p2) -> Objects.equals(p1.getValue(), p2.getValue()) ? p2.getKey().compareTo(p1.getKey()) : p1.getValue() - p2.getValue());
        this.max = new PriorityQueue<>((p1, p2) -> Objects.equals(p1.getValue(), p2.getValue()) ? p1.getKey().compareTo(p2.getKey()) : p2.getValue() - p1.getValue());
    }

    public void add(String name, int score) {
        min.add(new Pair<>(name, score));
        if (min.size() > idx) {
            System.out.println(min.peek());
            max.add(min.poll());
        }
    }

    public String get() {
        String res = min.peek().getKey();
        idx++;
        while (min.size() < idx && !max.isEmpty())
            min.add(max.poll());
        return res;
    }

    public static void main(String[] args) {
        SORTracker tracker = new SORTracker();
//        tracker.add("happy", 100000);
//        tracker.add("thanks", 100000);
//        tracker.add("giving", 99999);
//        tracker.add("everyone", 11111);
//        System.out.println(tracker.get());// happy
//        System.out.println(tracker.get());// thanks
//        System.out.println(tracker.get());// giving
//        System.out.println(tracker.get());// everyone
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>((p1, p2) -> Objects.equals(p1.getValue(), p2.getValue()) ? p2.getKey().compareTo(p1.getKey()) : p1.getValue() - p2.getValue());
        q.add(new Pair<>("happy", 100000));
        q.add(new Pair<>("thanks", 100000));
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println("thanks".compareTo("happy"));

    }
}
