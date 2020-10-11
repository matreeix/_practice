package _CONTEST._biweekly._36;


import java.util.*;

/**
 * @Description: 1606. 找到处理最多请求的服务器
 * 你有 k 个服务器，编号为 0 到 k-1 ，它们可以同时处理多个请求组。每个服务器有无穷的计算能力但是 不能同时处理超过一个请求 。请求分配到服务器的规则如下：
 * <p>
 * 1.第 i （序号从 0 开始）个请求到达。
 * 2.如果所有服务器都已被占据，那么该请求被舍弃（完全不处理）。
 * 3.如果第 (i % k) 个服务器空闲，那么对应服务器会处理该请求。
 * 4.否则，将请求安排给下一个空闲的服务器（服务器构成一个环，必要的话可能从第 0 个服务器开始继续找下一个空闲的服务器）。比方说，如果第 i 个服务器在忙，那么会查看第 (i+1) 个服务器，第 (i+2) 个服务器等等。
 * 给你一个 严格递增 的正整数数组 arrival ，表示第 i 个任务的到达时间，和另一个数组 load ，其中 load[i] 表示第 i 个请求的工作量（也就是服务器完成它所需要的时间）。你的任务是找到 最繁忙的服务器 。最繁忙定义为一个服务器处理的请求数是所有服务器里最多的。
 * <p>
 * 请你返回包含所有 最繁忙服务器 序号的列表，你可以以任意顺序返回这个列表。
 * @Author: matreeix
 * @Date: 2020/10/3
 */

public class Solution4 {

    //优先队列+TreeMap
    //Node类，把服务器编号与运行截止时间绑在一起丢进优先队列，实现排序接口
    private class Node implements Comparable<Node> {
        int server;
        int time;

        Node(int server, int time) {
            this.server = server;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return this.time - other.time;
        }
    }

    //优先队列用于维护运行服务器截止时间，每次插入LogN
    PriorityQueue<Node> Q = new PriorityQueue<Node>();
    //维护空闲服务器，便于查找（每次查找耗时LogN）
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        //记录每个服务器接收请求数
        int[] num = new int[k];
        //初始，每个服务器都可用，丢进TreeMap
        for (int i = 0; i < k; i++) {
            treeMap.put(i, 0);
        }

        for (int i = 0; i < arrival.length; i++) {

            //接收第i个请求时，把已运行截止的请求从优先队列中删掉，并释放对应的服务器（丢进treeMap）
            while (!Q.isEmpty() && Q.peek().time < arrival[i]) {
                treeMap.put(Q.peek().server, 0);
                Q.poll();
            }

            //找第i%k服务器是否空闲，如果不空闲找它后面的空闲的服务器【treeMap特性，ceilingKey()返回>=i%k最小的空闲服务器号】
            Integer index = treeMap.ceilingKey(i % k);
            //index是包装类，所以找不到时等于null
            if (index == null) {
                //如果>=i%k找不到，那么从0开始找
                index = treeMap.ceilingKey(-1);
            }
            //如果还是找不到空闲服务器，则舍弃该请求，所以只需判断index != null的情况
            if (index != null) {
                //把该请求的截止时间丢进优先队列，注意load是持续时间，所以要-1
                Q.add(new Node(index, arrival[i] + load[i] - 1));
                //index开始运行，那么把index服务器从treeMap中去掉
                treeMap.remove(index);
                //记录第index服务器累计接收请求数+1
                num[index]++;
            }
        }
        //找最大请求数
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, num[i]);
        }

        List<Integer> ans = new ArrayList<>();
        //把=最大请求数的服务器编号丢进答案
        for (int i = 0; i < k; i++) {
            if (num[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }

}
