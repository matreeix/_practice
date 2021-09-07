package _leetcode.heap._502;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description: 502. IPO
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
 * 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 * @Date: 2021/9/7
 */

public class Solution {

    //TLE
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(capital[i])) {
                PriorityQueue<Integer> q = map.get(capital[i]);
                q.add(profits[i]);
            } else {
                PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> (o2 - o1));
                q.add(profits[i]);
                map.put(capital[i], q);
            }
        }

        Arrays.sort(capital);
        while (k > 0) {
            int tmp = 0;
            int cos = -1;
            for (int c : capital) {
                if (c <= w && map.get(c).size() > 0) {
                    if (map.get(c).peek() > tmp) {
                        tmp = map.get(c).peek();
                        cos = c;
                    }
                }
            }
            if (cos == -1) break;
            tmp = map.get(cos).poll();
            w += tmp;
            k--;
        }
        return w;
    }

    //时间复杂度，O(NlogN)
    public int findMaximizedCapital2(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }

            if (pqPro.isEmpty()) break;

            W += pqPro.poll()[1];
        }

        return W;
    }
}
