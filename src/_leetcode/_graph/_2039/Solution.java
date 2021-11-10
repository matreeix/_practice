package _leetcode._graph._2039;

import java.util.*;

/**
 * @Description: 2039. 网络空闲的时刻
 * 给你一个有 n 个服务器的计算机网络，服务器编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示服务器 ui 和 vi 之间有一条信息线路，
 * 在 一秒 内它们之间可以传输 任意 数目的信息。再给你一个长度为 n 且下标从 0 开始的整数数组 patience 。
 * 题目保证所有服务器都是 相通 的，也就是说一个信息从任意服务器出发，都可以通过这些信息线路直接或间接地到达任何其他服务器。
 * 编号为 0 的服务器是 主 服务器，其他服务器为 数据 服务器。每个数据服务器都要向主服务器发送信息，并等待回复。信息在服务器之间按 最优 线路传输，
 * 也就是说每个信息都会以 最少时间 到达主服务器。主服务器会处理 所有 新到达的信息并 立即 按照每条信息来时的路线 反方向 发送回复信息。
 * 在 0 秒的开始，所有数据服务器都会发送各自需要处理的信息。从第 1 秒开始，每 一秒最 开始 时，每个数据服务器都会检查它是否收到了主服务器的回复信息（包括新发出信息的回复信息）：
 * 如果还没收到任何回复信息，那么该服务器会周期性 重发 信息。数据服务器 i 每 patience[i] 秒都会重发一条信息，也就是说，数据服务器 i 在上一次发送信息给主服务器后的 patience[i] 秒 后 会重发一条信息给主服务器。
 * 否则，该数据服务器 不会重发 信息。
 * 当没有任何信息在线路上传输或者到达某服务器时，该计算机网络变为 空闲 状态。
 * <p>
 * 请返回计算机网络变为 空闲 状态的 最早秒数 。
 * @Date: 2021/11/10
 */

public class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            map.putIfAbsent(v1, new ArrayList<>());
            map.putIfAbsent(v2, new ArrayList<>());
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        int[] times = new int[n];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int[] tmpV = new int[q.size()];
            for (int i = 0; i < tmpV.length; i++) tmpV[i] = q.poll();
            for (int v : tmpV) {
                List<Integer> adjs = map.get(v);
                for (int adj : adjs) {
                    if (!visited[adj]) {
                        q.add(adj);
                        visited[adj] = true;
                    }
                }
                times[v] = 2 * time;
            }
            time++;
        }
        int res = 0;
        for (int i = 1; i < patience.length; i++)
            res = Math.max(res, ((times[i] - 1) / patience[i]) * patience[i] + times[i]);
        return res + 1;
    }
}
